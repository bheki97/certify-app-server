package za.ac.tut.bheki97.certifyapp.document;

import jakarta.persistence.*;
import za.ac.tut.bheki97.certifyapp.user.User;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doc_id")
    private long docId;
    @Column(name = "doc_name")
    private String docName;

    @Column(name = "file_name")
    private String fileName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Document() {
    }


    public Document(long docId, String docName, String fileName, User user) {
        this.docId = docId;
        this.docName = docName;
        this.fileName = fileName;
        this.user = user;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return docId == document.docId && Objects.equals(docName, document.docName) && Objects.equals(fileName, document.fileName) && Objects.equals(user, document.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(docId, docName, fileName, user);
    }

    @Override
    public String toString() {
        return "Document{" +
                "docId=" + docId +
                ", docName='" + docName + '\'' +
                ", fileName='" + fileName + '\'' +
                ", user=" + user +
                '}';
    }
}
