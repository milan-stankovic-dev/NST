package nst.springboot.restexample01.controller.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "tbl_director")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Director's name must be inputted.")
    @Size(min = 2, max = 25, message = "Director's first name must" +
            "be from 2 to 25 characters.")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Director's last name must be inputted.")
    @Size(min = 2, max = 25, message = "Director's last name must" +
            "be from 2 to 25 characters.")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "start_date")
    @NotNull
    @PastOrPresent
    private Instant startDate;

    @Column(name="end_date")
    @NotNull
    @Future
    private Instant endDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_history_id")
    private DirectorHistory directorHistory;

}
