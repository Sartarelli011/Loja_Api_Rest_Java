package br.com.sartarelli011.loja.security;

import br.com.sartarelli011.loja.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    String secret;


    public String generateToken(User user) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            var token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getEmail())
                    .withExpiresAt(generateExpiresTime())
                    .sign(algorithm);
            return token;

        } catch (JWTCreationException e) {
            throw new RuntimeException("Error while generating token.", e);
        }
    }

    public String validateToken(String token) {
        DecodedJWT decodedJWT;

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier jwtVerifier = JWT.require(algorithm)
                    .withIssuer("auth-api").build();
            decodedJWT = jwtVerifier.verify(token);
            return decodedJWT.getSubject();
        } catch (IllegalArgumentException | JWTVerificationException exception) {
            throw new RuntimeException("Token inválido ou expirado", exception);
        }


    }


    private Instant generateExpiresTime() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
