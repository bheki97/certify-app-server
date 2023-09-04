package za.ac.tut.bheki97.certifyapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.tut.bheki97.certifyapp.dept.dto.DepartmentDto;
import za.ac.tut.bheki97.certifyapp.dept.service.DeptService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/dept")
public class DepartmentController {


    @Autowired
    private DeptService serv;


    @PostMapping
    public DepartmentDto addDepartment(@RequestParam("content") MultipartFile stamp,
                                     @RequestParam("deptName")String deptName) throws IOException {

        return serv.addDepartment(new DepartmentDto(deptName,stamp.getOriginalFilename(),stamp.getBytes()));

    }

    @GetMapping("/{id}")
    public DepartmentDto getById(@PathVariable long id) throws IOException {
        return serv.getDepartmentById(id);
    }

    @GetMapping
    public List<DepartmentDto> getAll(){
        return serv.getAllDepartments();
    }

    @PutMapping
    public DepartmentDto updateDept(@RequestParam("content") MultipartFile stamp,
                                    @RequestParam("id") long id,
                                    @RequestParam("userId")String deptName,
                                    @RequestParam("docName")String docName) throws IOException {
        return serv.updateDepartment(new DepartmentDto(id,deptName, stamp.getOriginalFilename(), stamp.getBytes()));
    }

    @DeleteMapping("/{id}")
    public boolean delById(@PathVariable long id){
        return serv.removeDepartmentById(id);
    }


}
