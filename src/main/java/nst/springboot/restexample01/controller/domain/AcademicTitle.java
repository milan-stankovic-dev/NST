package nst.springboot.restexample01.controller.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "academic_title")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "educationTitle")
    private AcademicTitleHistory academicTitleHistory;
}
