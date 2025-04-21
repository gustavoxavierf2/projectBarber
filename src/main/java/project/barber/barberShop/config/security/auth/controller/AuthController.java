package project.barber.barberShop.config.security.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import project.barber.barberShop.config.exceptions.GenericValidationException;
import project.barber.barberShop.config.security.auth.controller.dto.LoginDto;
import project.barber.barberShop.config.security.auth.controller.dto.RegisterUserDto;
import project.barber.barberShop.config.security.auth.controller.dto.TokenDto;
import project.barber.barberShop.config.security.auth.model.UserEntity;
import project.barber.barberShop.config.security.auth.repository.UserRepository;
import project.barber.barberShop.config.security.mapper.UserMapper;
import project.barber.barberShop.config.security.token.TokenKeyService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenKeyService tokenKeyService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> authenticate(@RequestBody LoginDto request){
        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(request.email(), request.senha());
        
        var authenticated = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var token = tokenKeyService.generateToken((UserEntity) authenticated.getPrincipal());

        return ResponseEntity.status(HttpStatus.OK).body(new TokenDto(token));
    }

    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserDto dto) throws GenericValidationException {
        if (userRepository.findByEmail(dto.email()) != null) {
            throw new GenericValidationException("E-mail já cadastrado.", HttpStatus.BAD_REQUEST);
        }
        var user = UserEntity.builder()
                .email(dto.email())
                .userPassword(passwordEncoder.encode(dto.userPassword()))
                .typeEnum(dto.typeEnum())
                .name(dto.name())
                .active(true)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(
                UserMapper.INSTANCE.toDto(userRepository.save(user)));
    }

}
