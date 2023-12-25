package nst.springboot.restexample01.domain.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import nst.springboot.restexample01.domain.BaseEntity;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_secretary_history")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SecretaryHistory implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    @NotNull
    @PastOrPresent
    private LocalDate startDate;

    @Column(name = "end_date")
    @NotNull
    @FutureOrPresent
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "secretary_id")
    private Secretary secretary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;

    @Override
    public String toString() {
        return "SecretaryHistory{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", secretary=" + (secretary == null? null : secretary.getId()) +
                ", department=" + (department == null? null : department.getId())  +
                '}';
    }
}
