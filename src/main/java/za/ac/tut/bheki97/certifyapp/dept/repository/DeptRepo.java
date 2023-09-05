package za.ac.tut.bheki97.certifyapp.dept.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.tut.bheki97.certifyapp.dept.Department;

public interface DeptRepo extends JpaRepository<Department,Long> {

    boolean existsByDeptName(String name);


}
