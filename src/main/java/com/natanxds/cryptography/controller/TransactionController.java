package com.natanxds.cryptography.controller;

import com.natanxds.cryptography.dto.CreateTransactionRequest;
import com.natanxds.cryptography.dto.TransactionResponse;
import com.natanxds.cryptography.dto.UpdateTransactionValueRequest;
import com.natanxds.cryptography.service.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateTransactionRequest createTransactionRequest) {
        transactionService.create(createTransactionRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> create(@PathVariable("id") Long id, @RequestBody UpdateTransactionValueRequest updateTransactionValueRequest) {
        transactionService.update(updateTransactionValueRequest, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<TransactionResponse>> listAll(@RequestParam(defaultValue = "0") Integer page,
                                                             @RequestParam(defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(transactionService.listAll(page, pageSize));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(transactionService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
