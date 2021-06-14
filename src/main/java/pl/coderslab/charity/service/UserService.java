package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.model.User;

public interface UserService {

    User findByUserName(String name);

    void saveUser(UserDto userDto);

    boolean checkPassword(UserDto userDto);

    boolean userExist(UserDto userDto);

    Integer numberOfUsers();

}
