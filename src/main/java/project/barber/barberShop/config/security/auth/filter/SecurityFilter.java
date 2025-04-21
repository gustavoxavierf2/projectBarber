package project.barber.barberShop.config.security.auth.filter;

import java.io.IOException;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import project.barber.barberShop.config.security.auth.repository.UserRepository;
import project.barber.barberShop.config.security.token.TokenKeyService;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter{

    private final TokenKeyService tokenKeyService;

    //private final UserRepository userRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                var token = recoverToken(request);
                if (token != null) {
                    var login = tokenKeyService.validationToken(token);
                    String role = tokenKeyService.getRoleFromToken(token);

                    // cria uma lista de authorities baseada na role do token
                    List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + role));

                    // cria um userDetails fake só com as infos do token
                    UserDetails user = new org.springframework.security.core.userdetails.User(login, "", authorities);

                    var authentication = new UsernamePasswordAuthenticationToken(user, null,user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }

                filterChain.doFilter(request, response);
            }

    private String recoverToken(HttpServletRequest request){
        var requestHeader = request.getHeader("Authorization");
        if (requestHeader == null) {
            return null;
        }

        return requestHeader.replace("Bearer ", "");
    }
}
