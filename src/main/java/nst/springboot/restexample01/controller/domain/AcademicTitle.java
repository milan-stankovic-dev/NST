package nst.springboot.restexample01.controller.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    @Size(min = 2, max = 30, message = "Title name must be between 2 and 30" +
            "characters.")
    @Column(name = "title_name")
    private String titleName;

    @OneToOne(mappedBy = "academicTitle")
    private AcademicTitleHistory academicTitleHistory;
}
