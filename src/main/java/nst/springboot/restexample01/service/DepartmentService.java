/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nst.springboot.restexample01.service;

import java.util.List;

import nst.springboot.restexample01.dto.DepartmentDTO;
/**
 *
 * @author student2
 */
public interface DepartmentService {
    DepartmentDTO save(DepartmentDTO departmentDto) throws Exception;
    List<DepartmentDTO> getAll();
    void delete(Long id) throws Exception;
    void update(DepartmentDTO department) throws Exception;
    DepartmentDTO findById(Long id) throws Exception;
}
