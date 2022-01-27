package com.depanneur_ste_helene.inventory_system.User.models;

import com.depanneur_ste_helene.inventory_system.User.repository.UserRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<UserDTO> getAllUsersDTO(){
        return userMapper.userListToUserDTOList(getAllUsers());
    }

    public User getUserByUserId(long userId) throws NoSuchElementException {
        return userRepository.findByUserId(userId).orElseThrow(() -> new NoSuchElementException("No user found for userId: " + userId));
    }

    @Override
    public UserDTO getUserDTOByUserId(long userId) throws NoSuchElementException {
        return userMapper.userToUserDTO(getUserByUserId(userId));
    }
}
