package za.ac.tut.bheki97.certifyapp.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.tut.bheki97.certifyapp.dept.Department;
import za.ac.tut.bheki97.certifyapp.dept.dto.DepartmentDto;
import za.ac.tut.bheki97.certifyapp.dept.exception.DeptartmentException;
import za.ac.tut.bheki97.certifyapp.dept.repository.DeptRepo;
import za.ac.tut.bheki97.certifyapp.office.Office;
import za.ac.tut.bheki97.certifyapp.office.exception.OfficeException;
import za.ac.tut.bheki97.certifyapp.office.dto.OfficeDto;
import za.ac.tut.bheki97.certifyapp.office.repository.OfficeRepo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService{

    @Autowired
    private OfficeRepo repo;

    @Autowired
    private DeptRepo deptRepo;

    private String stampFolderPath = "C:\\java-progs\\certify-app\\src\\main\\resources\\static\\off-stamps\\";


    @Override
    public OfficeDto addOffice(OfficeDto dto) throws IOException, OfficeException {

        if(!deptRepo.existsById(dto.getDeptId()))
            throw new OfficeException("Cannot add Office with non existing Department");

        if(repo.existsByOffName(dto.getOffName()))
            throw new OfficeException("Cannot add Office, Office with same name already exist");

        String fileName = dto.getOffName()+"-"+dto.getStampName();
        String path  =stampFolderPath +fileName;

        Files.write(Paths.get(path),dto.getStampContent());

        dto.setStampName(fileName);

        return generateDto(dto.toOffice());
    }

    @Override
    public OfficeDto updateOffice(OfficeDto dto) throws IOException, OfficeException {

        if(!deptRepo.existsById(dto.getDeptId()))
            throw new OfficeException("Cannot update Office to a non existing Department");

        if(!repo.existsById(dto.getOffId()))
            throw new OfficeException("Cannot update non existing Office");

        Path path = Paths.get(stampFolderPath+dto.getStampName());
        File file = path.toFile();

        if(file.exists()){
            if(Files.readAllBytes(path)!=dto.getStampContent())
                throw new OfficeException("Cannot update the Office with similar file name for stamp");

        }else {

            path = Paths.get(stampFolderPath+dto.getOffName()+"-"+dto.getStampName());

            //checks if the file exists
            //prevents overriding of file content
            if(path.toFile().exists())
                throw new OfficeException("Cannot update the Office with existing file name stamp");

            Files.write(path,dto.getStampContent());

            dto.setStampName(path.getFileName().toString());
        }

        return generateDto(repo.save(dto.toOffice()));
    }

    @Override
    public OfficeDto getOfficeById(long id) throws OfficeException, IOException {

        if(!repo.existsById(id))
            throw new OfficeException("Office does not exist");


        return generateDto(repo.findById(id).orElseThrow());
    }

    @Override
    public List<OfficeDto> getAllOffices() {
        return repo.findAll().stream().map(o ->{
                    try {
                        return generateDto(o);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                ).toList();
    }

    @Override
    public List<OfficeDto> getAllOfficesByDeptId(long deptId) {
        return  repo.findAllByDepartment_DeptId(deptId).stream().map(o ->{
                    try {
                        return generateDto(o);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).toList();
    }

    @Override
    public boolean deleteOfficeById(long id) throws OfficeException {
        return false;
    }

    private OfficeDto generateDto(Office dept)throws DeptartmentException,IOException{

        String path = stampFolderPath+dept.getStampName();


        if(!new File(path).exists())
            throw new DeptartmentException("Stamp Does not Exists");

        return new OfficeDto(dept.getOffId(), dept.getDept().getDeptId(),dept.getOffName(), dept.getStampName(), Files.readAllBytes(Paths.get(path)));

    }
}
