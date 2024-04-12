package lol.koblizek.czedu.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

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
    public ResponseEntity<SuccessfulAuthResponse> login(@RequestBody @Valid AuthRequest request) {
        if (true /* TODO: Implement a login check */) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
