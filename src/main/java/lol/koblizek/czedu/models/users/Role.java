package lol.koblizek.czedu.models.users;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ;
    private final String contextName;

    Role(String contextName) {
        this.contextName = contextName;
    }

    @Override
    public String getAuthority() {
        return contextName;
    }

    @Override
    public String toString() {
        return getAuthority();
    }
}
