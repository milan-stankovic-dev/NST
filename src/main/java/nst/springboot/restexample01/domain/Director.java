package nst.springboot.restexample01.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "tbl_director")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    @NotNull
    @PastOrPresent
    private Instant startDate;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

}