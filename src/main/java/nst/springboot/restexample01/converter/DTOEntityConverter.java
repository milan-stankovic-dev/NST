/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nst.springboot.restexample01.converter;

/**
 *
 * @author student2
 */
public interface DTOEntityConverter<DTO, ENTITY> {
    DTO toDto(ENTITY e);
    ENTITY toEntity(DTO t);
}
