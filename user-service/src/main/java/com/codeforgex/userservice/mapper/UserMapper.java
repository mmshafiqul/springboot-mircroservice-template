package com.codeforgex.userservice.mapper;

import com.codeforgex.userservice.dto.UserRequestDto;
import com.codeforgex.userservice.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserMapper {

    public static User toEntity(UserRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        
        return user;
    }

    public static Map<String, Object> toDto(User user) {
        if (user == null) {
            return null;
        }
        
        Map<String, Object> dto = new HashMap<>();
        dto.put("id", user.getId());
        dto.put("firstName", user.getFirstName());
        dto.put("lastName", user.getLastName());
        dto.put("email", user.getEmail());
        dto.put("phoneNumber", user.getPhoneNumber());
        
        return dto;
    }

    public static void updateEntityFromDto(UserRequestDto dto, User user) {
        if (dto == null || user == null) {
            return;
        }
        
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
    }

}
