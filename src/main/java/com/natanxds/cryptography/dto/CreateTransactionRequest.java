package com.natanxds.cryptography.dto;

public record CreateTransactionRequest(String userDocument, String creditCardToken, Long value) {
}
