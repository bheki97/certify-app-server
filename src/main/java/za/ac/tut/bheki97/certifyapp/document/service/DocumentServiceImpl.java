package za.ac.tut.bheki97.certifyapp.document.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import za.ac.tut.bheki97.certifyapp.document.Document;
import za.ac.tut.bheki97.certifyapp.document.dto.DocumentDto;
import za.ac.tut.bheki97.certifyapp.document.exception.DocException;
import za.ac.tut.bheki97.certifyapp.document.respository.DocumentRepo;
import za.ac.tut.bheki97.certifyapp.user.exception.UserException;
import za.ac.tut.bheki97.certifyapp.user.repository.UserRepo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    private DocumentRepo docRepo;

    @Autowired
    private UserRepo userRepo;


    private String documentFolderPath = "C:\\java-progs\\certify-app\\src\\main\\resources\\static\\docs\\";


    @Override
    public DocumentDto addDocument(DocumentDto dto) throws UserException, DocException, IOException {

        //check if the user exists
        if(!userRepo.existsById(dto.getUserId()))
            throw new UserException("Cannot add a Document of an invalid User");


        String fileName = saveDocumentFile(dto.getUserId(), dto.getFileName(), dto.getContent());
        dto.setFileName(fileName);
        return generateDtoFromDoc(docRepo.save(dto.returnDocument()));
    }

    @Override
    public DocumentDto updateDocument(DocumentDto dto) throws UserException, DocException, IOException {

        //check if the user exists
        if(!userRepo.existsById(dto.getUserId()))
            throw new UserException("Cannot update a Document of an Invalid User");

        if(!docRepo.existsByDocIdAndUser_Email(dto.getDocId(), dto.getUserId()))
            throw new DocException("Cannot update a Document that does not exists");

        Path path = Paths.get(documentFolderPath+dto.getFileName());
        File file = path.toFile();


        String fileName;
        //checks if the user made changes to the document
        //if the document exists, meaning there are changes made to the document
        if(file.exists()){
            if(Files.readAllBytes(path)==dto.getContent())
                fileName = file.getName();
            else throw new DocException("Cannot update a Document with similar file name");

        }else fileName = saveDocumentFile(dto.getUserId(), dto.getFileName(), dto.getContent());


        dto.setFileName(fileName);

        return generateDtoFromDoc(docRepo.save(dto.returnDocument()));
    }

    @Override
    public boolean removeDocument(long id) throws DocException {

        if(!docRepo.existsById(id))
            throw new DocException("Document Does not exists");


        Document doc  = docRepo.findById(id).orElseThrow();
        docRepo.deleteById(id);
        File file = Paths.get(documentFolderPath+doc.getFileName()).toFile();

        if(file.exists())
            return file.delete();


        return true;
    }



    @Override
    public DocumentDto getDocumentById(long docId) throws DocException, IOException {
        return generateDtoFromDoc(docRepo.findById(docId).orElseThrow());

    }

    @Override
    public List<DocumentDto> getAllUsersDocumentsByUserId(String email) {
        return  docRepo.findByUser_Email(email).stream().map(doc ->
                {
                    try {
                        return generateDtoFromDoc(doc);
                    } catch (DocException | IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).toList();
    }

    private String  saveDocumentFile(String userId, String fileName, byte[] content) throws DocException, IOException {
        String filePath = documentFolderPath +
                userId +
                "-" +
                fileName;

        Path path = Paths.get(filePath);


        //checks if the file exists
        //prevents overriding of file content
        if(path.toFile().exists())
            throw new DocException("Cannot add a Document with existing file name");

        Files.write(path,content);

        return path.getFileName().toString();
    }

    private DocumentDto generateDtoFromDoc(Document doc) throws DocException, IOException {

        Path path = Paths.get(documentFolderPath+doc.getFileName());

        if(!path.toFile().exists())
            throw new DocException("Document Does not Exists");



        return new DocumentDto(doc.getDocId(),doc.getDocName(),doc.getFileName(),Files.readAllBytes(path),doc.getUser().getEmail());
    }

}
