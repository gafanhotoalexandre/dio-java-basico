package me.simplebank.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Transação", description = "Gerenciamento de transações")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    @Operation(summary = "Criar transação", description = "Cria uma nova transação entre dois usuários")
    public ResponseEntity<Transaction> create(
            @Parameter(description = "Dados da transação") @RequestBody TransactionDTO transaction) throws Exception {
        Transaction newTransaction = this.transactionService.create(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }
}
