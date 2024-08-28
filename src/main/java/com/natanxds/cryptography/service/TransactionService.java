package com.natanxds.cryptography.service;

import com.natanxds.cryptography.dto.CreateTransactionRequest;
import com.natanxds.cryptography.dto.TransactionResponse;
import com.natanxds.cryptography.dto.UpdateTransactionValueRequest;
import com.natanxds.cryptography.entity.Transaction;
import com.natanxds.cryptography.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void create(CreateTransactionRequest createTransactionRequest) {
        var transactionEntity = new Transaction();
        transactionEntity.setRawUserDocument(createTransactionRequest.userDocument());
        transactionEntity.setRawCreditCardToken(createTransactionRequest.creditCardToken());
        transactionEntity.setTransactionValue(createTransactionRequest.value());

        transactionRepository.save(transactionEntity);
    }

    public Page<TransactionResponse> listAll(int page, int pageSize) {
        var content = transactionRepository.findAll(PageRequest.of(page, pageSize));

        return content.map(TransactionResponse::fromEntity);
    }

    public TransactionResponse findById(Long id) {
        var entity = transactionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return TransactionResponse.fromEntity(entity);
    }

    public void update(UpdateTransactionValueRequest updateTransactionValueRequest, Long id) {
        var entity = transactionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        entity.setTransactionValue(updateTransactionValueRequest.value());

        transactionRepository.save(entity);
    }

    public void delete(Long id) {
        var entity = transactionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        transactionRepository.delete(entity);
    }
}
