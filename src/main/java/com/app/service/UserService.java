package com.app.service;

import com.app.dao.UserRepository;
import com.app.dto.UserRequestDTO;
import com.app.dto.UserResponseDTO;
import com.app.entities.User;
import com.app.exceptions.CustomException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserResponseDTO getUserByName(String uname) {
        User user = userRepository.findByUname(uname);
        return modelMapper.map(user, UserResponseDTO.class);
    }

    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        User user = modelMapper.map(userRequestDTO, User.class);
        user = userRepository.save(user);
        return modelMapper.map(user, UserResponseDTO.class);
    }

    public void deleteUserById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new CustomException("User not found");
        }
        userRepository.deleteById(id);
    }

    // Other user-related services
}
