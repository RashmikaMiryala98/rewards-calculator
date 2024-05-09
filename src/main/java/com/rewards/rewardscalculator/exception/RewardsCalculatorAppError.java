package com.rewards.rewardscalculator.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RewardsCalculatorAppError {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
}
