package nst.springboot.restexample01.domain.impl;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nst.springboot.restexample01.domain.BaseEntity;

@Entity
@Table(name = "tbl_academic_title")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicTitle implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 30, message = "Title name must be between 2 and 30" +
            "characters.")
    @Column(name = "name")
    private String titleName;

}
