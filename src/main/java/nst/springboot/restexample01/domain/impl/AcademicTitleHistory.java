package nst.springboot.restexample01.domain.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nst.springboot.restexample01.domain.BaseEntity;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_academic_title_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicTitleHistory implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
//    @PastOrPresent
    private LocalDate startDate;

    @NotNull
//    @FutureOrPresent
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;

    @ManyToOne
    @JoinColumn(name = "academic_title_id")
    private AcademicTitle academicTitle;

    @ManyToOne
    @JoinColumn(name = "scientific_field_id")
    private ScientificField scientificField;
}
