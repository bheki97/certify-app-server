package za.ac.tut.bheki97.certifyapp.document.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.tut.bheki97.certifyapp.document.Document;

import java.util.List;

public interface DocumentRepo extends JpaRepository<Document,Long> {


    boolean existsByDocIdAndUser_Email(long docId,String UserEmail);

    List<Document> findByUser_Email(String email);
}
