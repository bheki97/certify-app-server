package za.ac.tut.bheki97.certifyapp.document.service;

import za.ac.tut.bheki97.certifyapp.document.dto.DocumentDto;
import za.ac.tut.bheki97.certifyapp.document.exception.DocException;
import za.ac.tut.bheki97.certifyapp.user.exception.UserException;

import java.io.IOException;
import java.util.List;

public interface DocumentService {

    DocumentDto addDocument(DocumentDto dto) throws UserException, DocException, IOException;
    DocumentDto updateDocument(DocumentDto dto) throws UserException, DocException, IOException;
    boolean removeDocument(long id)throws DocException;
    DocumentDto getDocumentById(long docId) throws DocException, IOException;
    List<DocumentDto> getAllUsersDocumentsByUserId(String email);


}
