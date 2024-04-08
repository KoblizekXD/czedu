package lol.koblizek.czedu.models.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lol.koblizek.czedu.util.validation.Nationality;
import lol.koblizek.czedu.util.validation.PhoneNumber;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "users")
public abstract class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @PhoneNumber
    private String phoneNumber;
    @Nationality
    @Column(nullable = false)
    private String nationality;
    @ElementCollection(targetClass = Role.class)
    private List<Role> roles;
    private String gender;
    @Column(nullable = false)
    private LocalDateTime dob;

    /**
     * Profile picture URL
     */
    @Column(name = "profile_picture")
    private String profilePicture;
    /**
     * Additional information about the user issued by school
     */
    @Column(name = "additional_info")
    private String additionalInfo;

    // TODO: Add remaining columns when they're added, such as Classes, Schools etc.

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
