package com.rpg.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class UserJWTProvider {

    @Value("${security.token.secret.user}")
    private String key;

    public DecodedJWT validToken(String token) {

        token = token.replace("Bearer ", "");

        Algorithm algorithm = Algorithm.HMAC256(token);

        try {

            var validToken = JWT.require(algorithm)
                    .build()
                    .verify(token);

            return validToken;

        } catch (JWTVerificationException e) {

            e.printStackTrace();
            return null;
        }

    }

}
