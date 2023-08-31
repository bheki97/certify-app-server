package za.ac.tut.bheki97.certifyapp.document.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.springframework.web.multipart.MultipartFile;
import za.ac.tut.bheki97.certifyapp.document.Document;
import za.ac.tut.bheki97.certifyapp.user.User;

import java.io.File;
import java.util.Arrays;

public class DocumentDto {


    private long docId;
    private String docName;
    private byte[] content;
    private String fileName;
    private String userId;

    public DocumentDto() {
    }

    public DocumentDto(String docName,String fileName, byte[] content, String userId) {
        this.docName = docName;
        this.content = content;
        this.userId = userId;
        this.fileName = fileName;
    }

    public DocumentDto(long docId, String docName, String fileName, byte[] content, String userId) {
        this.docId = docId;
        this.docName = docName;
        this.content = content;
        this.userId = userId;
        this.fileName = fileName;
    }



    public Document returnDocument(){
        return new Document(this.docId,this.docName,fileName,new User(this.userId));
    }

    public long getDocId() {
        return docId;
    }

    public void setDocId(long docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DocumentDto{" +
                "docId=" + docId +
                ", docName='" + docName + '\'' +
                ", content=" + Arrays.toString(content) +
                ", fileName='" + fileName + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
