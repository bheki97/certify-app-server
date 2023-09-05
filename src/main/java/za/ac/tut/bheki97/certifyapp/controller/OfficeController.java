package za.ac.tut.bheki97.certifyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.tut.bheki97.certifyapp.office.dto.OfficeDto;
import za.ac.tut.bheki97.certifyapp.office.service.OfficeService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    private OfficeService service;


    @PostMapping
    public OfficeDto create(@RequestParam("stamp") MultipartFile stamp,
                            @RequestParam("dept_id")long deptId,
                            @RequestParam("offName")String offName) throws IOException {

        return service.addOffice(new OfficeDto(deptId,offName,stamp.getOriginalFilename(),stamp.getBytes()));
    }

    @GetMapping
    public List<OfficeDto> getAll(){
        return service.getAllOffices();
    }

    @GetMapping("/dept/{id}")
    public List<OfficeDto> getAllByDept(@PathVariable long id){
        return service.getAllOfficesByDeptId(id);
    }

    @GetMapping("/{id}")
    public OfficeDto getById(@PathVariable long id) throws IOException {
        return service.getOfficeById(id);
    }

    @PutMapping
    public OfficeDto updateOffice(@RequestParam("stamp") MultipartFile stamp,
                            @RequestParam("dept_id")long offId,
                            @RequestParam("dept_id")long deptId,
                            @RequestParam("offName")String offName) throws IOException {

        return service.updateOffice(new OfficeDto(offId,deptId,offName,stamp.getOriginalFilename(),stamp.getBytes()));
    }

    @DeleteMapping("/{id}")
    public boolean delById(@PathVariable long id){
        return service.deleteOfficeById(id);
    }


}
