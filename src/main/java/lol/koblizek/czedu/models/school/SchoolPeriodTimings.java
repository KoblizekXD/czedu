package lol.koblizek.czedu.models.school;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@Entity
@Table(name = "school_period_timings")
public final class SchoolPeriodTimings {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @MapsId
    private School school;
    private final LocalTime defaultStartTime;
    private final int defaultPeriodLength;

    SchoolPeriodTimings(LocalTime defaultStartTime, int defaultPeriodLength) {
        this.defaultStartTime = defaultStartTime;
        this.defaultPeriodLength = defaultPeriodLength;
    }

    public SchoolPeriodTimings() {
        this(LocalTime.of(8, 0), 45);
    }
}
