/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nst.springboot.restexample01.controller.service;

import java.util.List;

import nst.springboot.restexample01.dto.SubjectDTO;

/**
 *
 * @author student2
 */
public interface SubjectService {
    SubjectDTO save(SubjectDTO subjectDto)throws Exception;
    List<SubjectDTO> getAll();
    void delete(Long id) throws Exception;
    void update(SubjectDTO subjectDto)throws Exception;
    SubjectDTO findById(Long id)throws Exception;
}
