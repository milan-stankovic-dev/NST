package nst.springboot.restexample01.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "secretary_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecretaryHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "secretaryHistory")
    private Secretary secretary;

    @ManyToOne
    @JoinColumn
    private Department department;
}
