package nst.springboot.restexample01.controller.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_member")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Member's first name must be " +
            "inputted.")
    @Size(min = 2, max = 25, message = "Member's name must" +
            "be between 2 and 25 characters.")
    @Column(name = "first_name")
    private String firstName;
    @NotEmpty(message = "Member's last name must be " +
            "inputted.")
    @Size(min = 2, max = 25, message =  "Members' last name " +
            "must be between 2 and 25 characters.")
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "academic_title_id")
    private AcademicTitle academicTitle;

    @ManyToOne
    @JoinColumn(name = "education_title_id")
    private EducationTitle educationTitle;

    @ManyToOne
    @JoinColumn(name = "scientific_title_id")
    private ScientificField scientificField;
}
