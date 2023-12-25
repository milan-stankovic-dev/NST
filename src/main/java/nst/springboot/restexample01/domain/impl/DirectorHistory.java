package nst.springboot.restexample01.domain.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import nst.springboot.restexample01.domain.BaseEntity;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_director_history")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DirectorHistory implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    @NotNull
//    @PastOrPresent
    private LocalDate startDate;

    @Column(name="end_date")
    @NotNull
//    @FutureOrPresent
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    @Override
    public String toString() {
        return "DirectorHistory{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", department=" + (department == null? null : department.getId()) +
                ", director=" + (director == null? null : director.getId()) +
                '}';
    }
}
