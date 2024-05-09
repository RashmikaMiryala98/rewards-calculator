package com.rewards.rewardscalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerRewards {
    private Long customerId;
    private Long firstMonthRewards;
    private Long secondMonthRewards;
    private Long thirdMonthRewards;
    private Long totalRewards;
}
