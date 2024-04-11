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
    private double[] breakTimes;

    SchoolPeriodTimings(LocalTime defaultStartTime, int defaultPeriodLength) {
        this.defaultStartTime = defaultStartTime;
        this.defaultPeriodLength = defaultPeriodLength;
        this.breakTimes = new double[] { 5d * 60 };
    }

    public SchoolPeriodTimings() {
        this(LocalTime.of(8, 0), 45);
    }

    /**
     * @param breakTime Breaks between periods in seconds
     */
    public void withBreaks(double... breakTime) {
        this.breakTimes = breakTime;
    }
}
