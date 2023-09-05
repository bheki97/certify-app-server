package za.ac.tut.bheki97.certifyapp.dept.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.tut.bheki97.certifyapp.dept.Department;
import za.ac.tut.bheki97.certifyapp.dept.dto.DepartmentDto;
import za.ac.tut.bheki97.certifyapp.dept.exception.DeptartmentException;
import za.ac.tut.bheki97.certifyapp.dept.repository.DeptRepo;
import za.ac.tut.bheki97.certifyapp.document.dto.DocumentDto;
import za.ac.tut.bheki97.certifyapp.document.exception.DocException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptRepo repo;
    private String stampFolderPath = "C:\\java-progs\\certify-app\\src\\main\\resources\\static\\dept-stamps\\";



    @Override
    public DepartmentDto addDepartment(DepartmentDto dto) throws DeptartmentException, IOException {

        if(repo.existsByDeptName(dto.getDeptName()))
            throw new DeptartmentException("Department Already Exists");

        String fileName = dto.getDeptName()+"-"+dto.getStampName();
        String path  =stampFolderPath +fileName;

        Files.write(Paths.get(path),dto.getStampContent());


        dto.setStampName(fileName);
        Department dept = dto.toDepartment();

        return generateDto(repo.save(dept));
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto dto) throws DeptartmentException, IOException {


        if(!repo.existsById(dto.getDeptId()))
            throw new DeptartmentException("Cannot update a Department that does not exists");

        Path path = Paths.get(stampFolderPath+dto.getStampName());
        File file = path.toFile();

        String fileName;
        //checks if the user made changes to the document
        //if the document exists, meaning there are changes made to the document
        if(file.exists()){
            if(Files.readAllBytes(path)!=dto.getStampContent())
                throw new DeptartmentException("Cannot update a Department with similar file name for stamp");

        }else {

            path = Paths.get(stampFolderPath+dto.getDeptName()+"-"+dto.getStampName());

            //checks if the file exists
            //prevents overriding of file content
            if(path.toFile().exists())
                throw new DeptartmentException("Cannot update a Department with existing file name stamp");

            Files.write(path,dto.getStampContent());

            dto.setStampName(path.getFileName().toString());
        }

        return generateDto(repo.save(dto.toDepartment()));
    }

    @Override
    public boolean removeDepartmentById(long id) throws DeptartmentException {
        return false;
    }

    @Override
    public DepartmentDto getDepartmentById(long id) throws DeptartmentException, IOException {

        if(!repo.existsById(id))
            throw new DeptartmentException("Department Does not exists");

        return generateDto(repo.findById(id).get());
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {


        return repo.findAll().stream().map(d ->{
            try {
                return generateDto(d);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }


    private DepartmentDto generateDto(Department dept)throws DeptartmentException,IOException{

        String path=stampFolderPath+dept.getStampName();

        if(!new File(path).exists())
            throw new DeptartmentException("Stamp Does not Exists");

        return new DepartmentDto(dept.getDeptId(), dept.getDeptName(), dept.getStampName(), Files.readAllBytes(Paths.get(path)));

    }
}
