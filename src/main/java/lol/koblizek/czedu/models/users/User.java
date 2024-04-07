package lol.koblizek.czedu.models.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lol.koblizek.czedu.util.validation.Nationality;
import org.hibernate.annotations.Nationalized;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String password;
    private String phoneNumber;
    @Nationality
    private String nationality;
    @ElementCollection(targetClass = Role.class)
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
}
