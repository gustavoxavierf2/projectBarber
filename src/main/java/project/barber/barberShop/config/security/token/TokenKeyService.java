package project.barber.barberShop.config.security.token;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import project.barber.barberShop.config.security.auth.model.UserEntity;

@Service
public class TokenKeyService {
    @Value("${api.security.token.secret}")
    private String secret;

    private Instant expirationToken(){
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }

    public String generateToken(UserEntity userEntity){
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            String token = JWT.create()
                .withIssuer("ws-barberShop")
                .withSubject(userEntity.getEmail())
                .withClaim("role", userEntity.getTypeEnum().name())
                .withExpiresAt(expirationToken())
                .sign(algoritmo);

            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro na geração do token", e);
        }
       
    }

    public String validationToken(String token){
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                .withIssuer("ws-barberShop")
                .build()
                .verify(token)
                .getSubject();

        } catch (JWTVerificationException e) {
            throw new RuntimeException("Token inválido ou expirado");
        }
    }

    public String getRoleFromToken(String token) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            var decodedJWT = JWT.require(algoritmo)
                    .withIssuer("ws-barberShop")
                    .build()
                    .verify(token);

            return decodedJWT.getClaim("role").asString();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Token inválido ou expirado", e);
        }
    }

}
