package za.ac.tut.bheki97.certifyapp.office.service;


import za.ac.tut.bheki97.certifyapp.office.exception.OfficeException;
import za.ac.tut.bheki97.certifyapp.office.dto.OfficeDto;

import java.io.IOException;
import java.util.List;

public interface OfficeService {


    OfficeDto addOffice(OfficeDto dto) throws IOException, OfficeException;
    OfficeDto updateOffice(OfficeDto dto) throws IOException,OfficeException;

    OfficeDto getOfficeById(long id) throws OfficeException,IOException;

    List<OfficeDto> getAllOffices();
    List<OfficeDto> getAllOfficesByDeptId(long deptId);



    boolean deleteOfficeById(long id)throws OfficeException;



}
