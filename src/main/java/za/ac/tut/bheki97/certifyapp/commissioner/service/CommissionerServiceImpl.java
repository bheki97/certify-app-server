package za.ac.tut.bheki97.certifyapp.commissioner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.tut.bheki97.certifyapp.commissioner.Commissioner;
import za.ac.tut.bheki97.certifyapp.commissioner.dto.CommissionerDto;
import za.ac.tut.bheki97.certifyapp.commissioner.exception.CommisionerException;
import za.ac.tut.bheki97.certifyapp.commissioner.repository.CommissionerRepo;
import za.ac.tut.bheki97.certifyapp.office.repository.OfficeRepo;
import za.ac.tut.bheki97.certifyapp.user.repository.UserRepo;

@Service
public class CommissionerServiceImpl implements CommissionerService{

    @Autowired
    private CommissionerRepo repo;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OfficeRepo officeRepo;



    @Override
    public boolean addCommissioner(CommissionerDto dto) {

        if(!userRepo.existsById(dto.getUserId()))
            throw new CommisionerException("Cannot add Commissioner with non existing username.");



        if(!officeRepo.existsById(dto.getOfficeId()))
            throw new CommisionerException("Cannot add Commissioner with non existing Office.");


        Commissioner com = new Commissioner(userRepo.findById(dto.getUserId()).orElseThrow(),
                dto.getAuthId(),officeRepo.findById(dto.getOfficeId()).orElseThrow());


        repo.save(com);

        userRepo.deleteById(dto.getUserId());

        return true;
    }

    private CommissionerDto generateDto(Commissioner com){
        CommissionerDto dto = new CommissionerDto();

        dto.setAuthId(com.getOathId());
        dto.setUserId(com.getEmail());
        dto.setAuthorized(com.isAuthorized());
        dto.setOfficeId(com.getOffice().getOffId());

        //if(com.getSignatureFileName()!=null);

        return dto;
    }



}
