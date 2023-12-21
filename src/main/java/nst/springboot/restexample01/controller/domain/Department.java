package nst.springboot.restexample01.controller.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_department")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Department name is obligatory.")
    @Size(min = 2, max = 10, message = "Department name must be from 2 to 10 characters" +
            " long.")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Department short name is obligatory.")
    @Size(min = 2, max = 5, message = "Department short name is between 2 and 5 characters " +
            "long.")
    @Column(name = "short_name")
    private String shortName;

    @ManyToOne
    @JoinColumn(name = "secretary_id")
    private Secretary secretary;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<SecretaryHistory> secretaryHistories;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<DirectorHistory> directorHistories;

}
