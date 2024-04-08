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
    private String name;
    private String address;

    // TODO: List of students, teachers, head teachers, classes, subjects, etc.
}
