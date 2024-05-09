package com.rewards.rewardscalculator.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {

    @NotNull(message = "Customer Id cannot be null")
    private Long customerId;

    @NotNull(message = "Transaction amount cannot be null")
    @Min(value = 1, message = "Transaction amount cannot be less than 1")
    private Double transactionAmount;
}

