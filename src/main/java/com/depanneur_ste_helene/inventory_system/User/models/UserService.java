package com.depanneur_ste_helene.inventory_system.User.models;

import javassist.NotFoundException;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsersDTO();
    UserDTO getUserDTOByUserId(long userId) throws NotFoundException;
}
