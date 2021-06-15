package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.model.User;

import java.util.List;

public interface UserService {

    User findByUserName(String name);

    void saveUser(UserDto userDto);

    boolean checkPassword(UserDto userDto);

    boolean userExist(UserDto userDto);

    Long numberOfUsers();

    List<UserDto> getAll();

    void delete(Long id);
}
