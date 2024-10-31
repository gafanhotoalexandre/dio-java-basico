package me.simplebank.service;

import me.simplebank.domain.model.user.User;

import java.math.BigDecimal;

public interface UserService {

    void create(User user);
    User findUserById(Long id) throws Exception;
    void validateTransaction(User sender, BigDecimal amount) throws Exception;
}
