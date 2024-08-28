package com.natanxds.cryptography.dto;

import com.natanxds.cryptography.entity.Transaction;

public record TransactionResponse(Long id, String userDocument, String creditCardToken, Long value) {

    public static TransactionResponse fromEntity(Transaction transactionEntity){
        return new TransactionResponse(
                transactionEntity.getTransactionId(),
                transactionEntity.getRawUserDocument(),
                transactionEntity.getRawCreditCardToken(),
                transactionEntity.getTransactionValue()
        );
    }
}
