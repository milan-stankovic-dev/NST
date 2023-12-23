package nst.springboot.restexample01.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "secretary_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecretaryHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    @NotNull
    @PastOrPresent
    private Instant startDate;

    @Column(name = "end_date")
    @NotNull
    @Future
    private Instant endDate;

    @ManyToOne
    @JoinColumn(name = "secretary_id")
    private Secretary secretary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;
}
