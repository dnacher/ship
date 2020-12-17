package com.ship.ship.domain.service;

import com.ship.ship.exceptions.UAuthException;
import com.ship.ship.persistence.model.User;
import com.ship.ship.dto.UserDTO;
import com.ship.ship.persistence.dao.UserDAO;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;
    private final Integer LOG_ROUNDS = 10;

    @Override
    public UserDTO validateUser(UserDTO userDTO) throws UAuthException {
        User hashedUser = userDAO.findByEmail(userDTO.getEmail());
        if(hashedUser!=null){
            if(BCrypt.checkpw(userDTO.getPassword(),hashedUser.getPassword())){
                return new UserDTO(hashedUser);
            }else{
                throw new UAuthException("Password or email incorrect");
            }
        }else {
            throw new UAuthException("Password or email incorrect");
        }
    }

    @Override
    public User registerUser(User user) throws UAuthException {
        Integer count = userDAO.countByEmail(user.getEmail());
        if(count>0){
            throw new UAuthException("this email is already in use");
        }else{
            String hashedPassword= BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(LOG_ROUNDS));
            user.setPassword(hashedPassword);
            return userDAO.saveUser(user);
        }
    }

    @Override
    public List<User> getUser() {
        return userDAO.getUser();
    }

    @Override
    public User getUserById(Integer id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    public UserDTO Login(UserDTO user){
        return this.validateUser(user);
    }
}
