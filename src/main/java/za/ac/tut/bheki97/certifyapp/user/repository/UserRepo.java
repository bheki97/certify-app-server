package za.ac.tut.bheki97.certifyapp.user.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import za.ac.tut.bheki97.certifyapp.user.User;

public interface UserRepo extends JpaRepository<User,String> {


    @Modifying
    @Transactional
    @Query("UPDATE User e SET e.active = :active WHERE e.email = :email")
    int deactivateAccount(String email, boolean active);


}
