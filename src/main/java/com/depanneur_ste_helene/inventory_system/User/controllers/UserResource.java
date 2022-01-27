package com.depanneur_ste_helene.inventory_system.User.controllers;


import com.depanneur_ste_helene.inventory_system.User.models.UserDTO;
import com.depanneur_ste_helene.inventory_system.User.models.UserService;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping("/users")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserResource {
    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping("/api/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDTO> getAllUsersDTO() {
        return userService.getAllUsersDTO();
    }

    @CrossOrigin
    @GetMapping("/api/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public UserDTO findUser(@PathVariable long userId) throws NoSuchElementException {
        return userService.getUserDTOByUserId(userId);
    }
}