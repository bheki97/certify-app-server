package za.ac.tut.bheki97.certifyapp.user.service;

import za.ac.tut.bheki97.certifyapp.user.User;
import za.ac.tut.bheki97.certifyapp.user.exception.UserException;

import java.util.List;

public interface UserService {

    boolean registerUser(User user) throws UserException;
    boolean deActivateAcc(String email);
    boolean updateAccount(User user)throws UserException;
    User getUserByEmail(String email);

    List<User> getAllUsers();

}
