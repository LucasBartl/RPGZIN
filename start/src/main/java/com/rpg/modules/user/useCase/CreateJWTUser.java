package com.rpg.modules.user.useCase;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.rpg.modules.user.dto.RequestUserDTO;
import com.rpg.modules.user.dto.ResponseUserDTO;
import com.rpg.modules.user.repository.UserRepository;


@Service
public class CreateJWTUser {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    private ResponseUserDTO responseUserDTO;

    @Value("${security.token.secret.user}")
    private String key;

    public ResponseUserDTO execute(RequestUserDTO dto) {

        var user = this.repository.findByUsername(dto.getUsername())
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("User not found");
                });

        var password = this.encoder.matches(dto.getPassword(), user.getPassword());

        if (!password) {
            throw new BadCredentialsException("Incorrect credentials");
        }

        Algorithm algorithm = Algorithm.HMAC256(key);

        var expires_in = Instant.now().plus(Duration.ofHours(1));

        var token = JWT.create()
                .withIssuer(user.getName())
                .withExpiresAt(expires_in)
                .withSubject(user.getId().toString())
                .sign(algorithm);

        var userResponse = this.responseUserDTO.builder()
                .accessToken(token)
                .expires_in(expires_in.toEpochMilli())
                .build();

        return userResponse;

    }

}
