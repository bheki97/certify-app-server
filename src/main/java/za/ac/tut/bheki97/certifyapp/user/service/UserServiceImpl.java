package za.ac.tut.bheki97.certifyapp.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.tut.bheki97.certifyapp.user.User;
import za.ac.tut.bheki97.certifyapp.user.exception.UserException;
import za.ac.tut.bheki97.certifyapp.user.repository.UserRepo;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo repo;

    @Override
    public boolean registerUser(User user) throws UserException {

        if(repo.existsById(user.getEmail()))
            throw new UserException("User Already exists");


        return repo.save(user).equals(user);
    }

    @Override
    public boolean deActivateAcc(String email) {
        return repo.deactivateAccount(email,false)>0;
    }

    @Override
    public boolean updateAccount(User user) throws UserException {

        if(!repo.existsById(user.getEmail()))
            throw new UserException("Cannot Update Account of a user that does not exist");

        return repo.save(user).equals(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return repo.findById(email).orElseThrow();
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
