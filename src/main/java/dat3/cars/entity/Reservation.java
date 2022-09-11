package dat3.cars.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity(name = "reservations")
public class Reservation {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Member member;

    @CreationTimestamp
    LocalDateTime createdDated;

    LocalDate rentalDate;

    public Reservation(Car car, Member member, LocalDate rentalDate) {
        this.car = car;
        this.member = member;
        this.rentalDate = rentalDate;
    }
}
