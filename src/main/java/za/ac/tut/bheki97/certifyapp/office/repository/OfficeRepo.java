package za.ac.tut.bheki97.certifyapp.office.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.tut.bheki97.certifyapp.office.Office;

import java.util.List;

public interface OfficeRepo extends JpaRepository<Office,Long> {

    boolean existsByOffName(String offName);
    List<Office> findAllByDept_DeptId(long id);

}
