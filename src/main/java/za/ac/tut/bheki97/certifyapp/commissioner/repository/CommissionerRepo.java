package za.ac.tut.bheki97.certifyapp.commissioner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.tut.bheki97.certifyapp.commissioner.Commissioner;

public interface CommissionerRepo extends JpaRepository<Commissioner,String> {

}
