package nst.springboot.restexample01.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDate;


public record DirectorDTO (
    Long id,
    LocalDate startDate,
    String firstName,
    String lastName,
    Long departmentId
)
{ }
