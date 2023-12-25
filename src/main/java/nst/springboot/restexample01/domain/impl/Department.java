package nst.springboot.restexample01.domain.impl;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import nst.springboot.restexample01.domain.BaseEntity;

import java.util.List;

@Entity
@Table(name = "tbl_department")
@Getter
@Setter
@EqualsAndHashCode
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

    @OneToOne(mappedBy = "department",
            cascade = CascadeType.ALL)
    @JoinColumn(name = "secretary_id")
    private Secretary secretary;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<SecretaryHistory> secretaryHistories;

    @OneToOne(mappedBy = "department",
    cascade = CascadeType.ALL)
    private Director director;

    @OneToMany(mappedBy = "department",
            cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<DirectorHistory> directorHistories;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", secretary=" + (secretary != null ? secretary.getId() : null) +
                 ", secretaryHistories=" + secretaryHistories +
                ", director=" + (director != null ? director.getId() : null) +
                ", directorHistories=" + directorHistories +
                '}';
    }

}
