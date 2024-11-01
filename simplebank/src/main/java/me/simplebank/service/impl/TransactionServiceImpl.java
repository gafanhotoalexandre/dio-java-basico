package me.simplebank.service.impl;

import me.simplebank.domain.model.transaction.Transaction;
import me.simplebank.domain.model.user.User;
import me.simplebank.dto.TransactionDTO;
import me.simplebank.repository.TransactionRepository;
import me.simplebank.service.NotificationService;
import me.simplebank.service.TransactionService;
import me.simplebank.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final UserService userService;
    private final TransactionRepository transactionRepository;
    private final RestTemplate restTemplate;
    private final NotificationService notificationService;

    public TransactionServiceImpl(
        UserService userService,
        TransactionRepository transactionRepository,
        RestTemplate restTemplate,
        NotificationService notificationService
    ) {
        this.userService = userService;
        this.transactionRepository = transactionRepository;
        this.restTemplate = restTemplate;
        this.notificationService = notificationService;
    }

    @Override
    public Transaction create(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());

        boolean isAuthorized = this.authorize(sender, transaction.value());
        if (!isAuthorized) {
            throw new Exception("Transação não autorizada");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        this.transactionRepository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);

        this.notificationService.sendNotification(sender, "Transação realizada com sucesso!");
        this.notificationService.sendNotification(receiver, "Transação recebida com sucesso!");

        return newTransaction;
    }

    @Override
    public boolean authorize(User sender, BigDecimal value) {
        ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);

        if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
            String status = (String) authorizationResponse.getBody().get("status");
            return "success".equalsIgnoreCase(status);
        } else return false;
    }
}
