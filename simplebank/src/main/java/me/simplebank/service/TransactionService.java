package me.simplebank.service;

import me.simplebank.domain.model.transaction.Transaction;
import me.simplebank.domain.model.user.User;
import me.simplebank.dto.TransactionDTO;

import java.math.BigDecimal;

public interface TransactionService {

    Transaction create(TransactionDTO transaction) throws Exception;
    boolean authorize(User sender, BigDecimal value);
}
