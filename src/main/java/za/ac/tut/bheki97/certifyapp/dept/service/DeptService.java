package za.ac.tut.bheki97.certifyapp.dept.service;

import za.ac.tut.bheki97.certifyapp.dept.dto.DepartmentDto;
import za.ac.tut.bheki97.certifyapp.dept.exception.DeptartmentException;

import java.io.IOException;
import java.util.List;

public interface DeptService {


    DepartmentDto addDepartment(DepartmentDto dto) throws DeptartmentException, IOException;
    DepartmentDto updateDepartment(DepartmentDto dto) throws DeptartmentException, IOException;

    boolean removeDepartmentById(long id) throws DeptartmentException;

    DepartmentDto getDepartmentById(long id) throws DeptartmentException, IOException;
    List<DepartmentDto> getAllDepartments();
}
