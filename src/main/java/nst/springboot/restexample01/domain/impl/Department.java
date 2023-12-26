package nst.springboot.restexample01.domain.impl;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import nst.springboot.restexample01.domain.BaseEntity;

import java.util.List;

@Entity
@Table(name = "tbl_department")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Department name is obligatory.")
    @Size(min = 2, max = 100, message = "Department name must be from 2 to 10 characters" +
            " long.")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Department short name is obligatory.")
    @Size(min = 1, max = 5, message = "Department short name is between 1 and 5 characters " +
            "long.")
    @Column(name = "short_name")
    private String shortName;

}
