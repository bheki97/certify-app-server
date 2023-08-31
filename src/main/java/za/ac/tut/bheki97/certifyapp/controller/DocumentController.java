package za.ac.tut.bheki97.certifyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.tut.bheki97.certifyapp.document.dto.DocumentDto;
import za.ac.tut.bheki97.certifyapp.document.exception.DocException;
import za.ac.tut.bheki97.certifyapp.document.service.DocumentService;
import za.ac.tut.bheki97.certifyapp.user.exception.UserException;

import java.io.IOException;

@RestController
@RequestMapping("/doc")
public class DocumentController {


    @Autowired
    private DocumentService docServ;


    @PostMapping
    public DocumentDto create(@RequestParam("content") MultipartFile file,
                              @RequestParam("userId")String userId,
                              @RequestParam("docName")String docName) throws UserException, IOException, DocException {

        return docServ.addDocument(new DocumentDto(docName,file.getOriginalFilename(),file.getBytes(), userId));
    }

    @PutMapping("/update")
    public DocumentDto update(@RequestBody DocumentDto dto) throws DocException, UserException, IOException {
        return docServ.updateDocument(dto);
    }

    @DeleteMapping("/del/{id}")
    public boolean delete(@PathVariable long id) throws DocException {
        return docServ.removeDocument(id);
    }

    @GetMapping("/{id}")
    public DocumentDto readById(@PathVariable long id) throws DocException, IOException {
        return docServ.getDocumentById(id);
    }




}
