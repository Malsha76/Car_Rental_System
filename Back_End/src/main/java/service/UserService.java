package service;

import dto.UserDTO;

import java.util.ArrayList;

/**
 * @author Malsha Ekanayaka
 */
public interface UserService {
    ArrayList<UserDTO> getAllRegUsers();

    UserDTO getRegUsers(String username,String password);

}
