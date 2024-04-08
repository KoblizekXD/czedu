package lol.koblizek.czedu.models.school;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "schools")
@Getter
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    private String description;

    // TODO: List of students, teachers, head teachers, classes, subjects, etc.
}
