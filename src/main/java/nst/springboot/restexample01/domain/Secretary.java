package nst.springboot.restexample01.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "tbl_secretary")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Secretary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Secretary's name must be inputted.")
    @Size(min = 2, max = 25, message = "First name must be from 2 to " +
            "25 characters.")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Secretary's last name must be inputted.")
    @Size(min = 2, max = 25, message = "Last name must be from 2 to " +
            "25 characters.")
    private String lastName;

    @Column(name = "start_date")
    @NotNull
    @PastOrPresent
    private Instant startDate;

    @Column(name = "end_date")
    @NotNull
    @Future
    private Instant endDate;

    @OneToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

}
