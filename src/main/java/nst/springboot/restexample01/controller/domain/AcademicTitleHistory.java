package nst.springboot.restexample01.controller.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "academic_title_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicTitleHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @PastOrPresent
    private Instant startDate;

    @NotNull
    @Future
    private Instant endDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "academic_title_id")
    private AcademicTitle academicTitle;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "scientific_field_id")
    private ScientificField scientificField;
}
