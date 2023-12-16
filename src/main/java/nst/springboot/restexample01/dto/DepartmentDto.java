/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nst.springboot.restexample01.controller.domain.Director;
import nst.springboot.restexample01.controller.domain.Secretary;

import java.io.Serializable;

/**
 *
 * @author student2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto implements Serializable{
    private Long id;
    
    @NotNull
    @Size(min = 2,max = 10, message = "Broj znakova [2-10]")
    private String name;

    @NotNull
    @Size(min = 2, max = 5, message = "Broj znakova [2-5]")
    private String shortName;

    private Secretary secretary;
    private Director director;
}
