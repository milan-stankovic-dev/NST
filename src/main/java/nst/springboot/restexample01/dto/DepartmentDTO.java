package nst.springboot.restexample01.dto;

import java.util.List;

public record DepartmentDTO(
    Long id,
    String name,
    String shortName,
    SecretaryDTO secretaryDTO,
    List<SecretaryHistoryDTO> secretaryHistories,
    DirectorDTO directorDTO,
    List<DirectorHistoryDTO> directorHistories
) { }
