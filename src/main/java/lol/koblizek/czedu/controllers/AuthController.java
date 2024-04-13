package lol.koblizek.czedu.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lol.koblizek.czedu.services.AuthService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public record AuthRequest(
            @Email @NotNull String username,
            @NotNull String password
    ) {}

    @Builder
    public record SuccessfulAuthResponse(
            String token,
            String refreshToken,
            LocalDateTime expiresAt
    ) {}

    @PostMapping
    public ResponseEntity<SuccessfulAuthResponse> login(Authentication auth, @RequestBody @Valid AuthRequest request) {
        Optional<String> optToken = authService.attemptAuth(auth, request.username(), request.password());
        return optToken.map(s -> ResponseEntity.ok(SuccessfulAuthResponse.builder()
                        .token(s)
                        .expiresAt(LocalDateTime.now().plusMinutes(authService.getExpirationTime()))
                        .refreshToken("TODO")
                        .build())
                )
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
