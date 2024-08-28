package com.natanxds.cryptography.entity;

import com.natanxds.cryptography.service.CryptographyService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tb_transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name = "user_document")
    private String encryptedUserDocument;

    @Column(name = "credit_card_value")
    private String encryptedCreditCardToken;

    @Column(name = "transaction_value")
    private Long transactionValue;

    @Transient
    private String rawUserDocument;

    @Transient
    private String rawCreditCardToken;

    @PrePersist
    public void prePersist() {
        this.encryptedUserDocument = CryptographyService.encrypt(rawUserDocument);
        this.encryptedCreditCardToken = CryptographyService.encrypt(rawCreditCardToken);
    }

    @PostLoad
    public void postLoad() {
        this.rawUserDocument = CryptographyService.decrypt(encryptedUserDocument);
        this.rawCreditCardToken = CryptographyService.decrypt(encryptedCreditCardToken);
    }
}
