package lol.koblizek.czedu.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthService {

    @Value("${czedu.auth.expiration}")
    private int expiration;

    public Optional<String> attemptAuth(Authentication auth, String user, String pass) {
        return Optional.empty();
    }

    public String generateScope(Authentication auth) {
        return auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
    }

    public int getExpirationTime() {
        return expiration;
    }
}
