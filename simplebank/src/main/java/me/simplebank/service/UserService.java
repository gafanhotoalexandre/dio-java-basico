package me.simplebank.service;

import me.simplebank.domain.model.user.User;
import me.simplebank.dto.UserDTO;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {

    User create(UserDTO user);
    void saveUser(User user);
    User findUserById(Long id) throws Exception;
    List<User> getAllUsers();

    void validateTransaction(User sender, BigDecimal amount) throws Exception;
}
