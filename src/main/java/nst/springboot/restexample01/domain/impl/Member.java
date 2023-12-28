package nst.springboot.restexample01.domain.impl;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nst.springboot.restexample01.domain.BaseEntity;
import nst.springboot.restexample01.role.MemberRole;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_member")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member implements BaseEntity {
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

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Column(name = "start_date")
    @PastOrPresent
    private LocalDate startDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "academic_title_id")
    private AcademicTitle academicTitle;

    @ManyToOne
    @JoinColumn(name = "education_title_id")
    private EducationTitle educationTitle;

    @ManyToOne
    @JoinColumn(name = "scientific_field_id")
    private ScientificField scientificField;

    @OneToMany(mappedBy = "member", cascade = CascadeType.MERGE,
    orphanRemoval = true)
    private List<AcademicTitleHistory> histories;

}
