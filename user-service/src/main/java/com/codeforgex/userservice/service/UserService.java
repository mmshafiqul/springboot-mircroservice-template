package com.codeforgex.userservice.service;

import com.codeforgex.userservice.dto.UserRequestDto;
import java.util.List;

public interface UserService {

    Object createUser(UserRequestDto userRequestDto);

    Object getUserById(Long id);

    List<Object> getAllUsers();

    Object updateUser(Long id, UserRequestDto userRequestDto);

    void deleteUser(Long id);

}
