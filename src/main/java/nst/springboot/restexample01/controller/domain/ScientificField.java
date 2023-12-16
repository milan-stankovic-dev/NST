package nst.springboot.restexample01.controller.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_scientific_field")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScientificField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "scientificField")
    private AcademicTitleHistory academicTitleHistory;
}
