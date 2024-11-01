package me.simplebank.controllers;

import me.simplebank.domain.model.transaction.Transaction;
import me.simplebank.dto.TransactionDTO;
import me.simplebank.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody TransactionDTO transaction) throws Exception {
        Transaction newTransaction = this.transactionService.create(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }
}
