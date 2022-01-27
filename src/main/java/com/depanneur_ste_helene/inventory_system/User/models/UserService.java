package com.depanneur_ste_helene.inventory_system.User.models;

import java.util.NoSuchElementException;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsersDTO();
    UserDTO getUserDTOByUserId(long userId) throws NoSuchElementException;
}
