package me.simplebank.service.impl;

import me.simplebank.domain.model.user.User;
import me.simplebank.domain.model.user.UserType;
import me.simplebank.dto.UserDTO;
import me.simplebank.repository.UserRepository;
import me.simplebank.service.UserService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuário do tipo LOGISTA não está autorizado a realizar transação.");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo Insuficiente");
        }
    }

    @Override
    public User findUserById(Long id) throws Exception {
        return this.userRepository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado."));
    }

    @Override
    public User create(UserDTO data) {
        User newUser = new User(data);

        this.saveUser(newUser);
        return newUser;
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
