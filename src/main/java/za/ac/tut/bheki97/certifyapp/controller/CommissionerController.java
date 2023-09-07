package za.ac.tut.bheki97.certifyapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.tut.bheki97.certifyapp.commissioner.dto.CommissionerDto;
import za.ac.tut.bheki97.certifyapp.commissioner.service.CommissionerService;

@RestController
@RequestMapping("/comm")
public class CommissionerController {

    @Autowired
    private CommissionerService service;


    @PostMapping
    public boolean createCom(@RequestBody CommissionerDto dto){
        return service.addCommissioner(dto);
    }
}
