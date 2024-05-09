package com.rewards.rewardscalculator.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardsDto {
    private Long customerId;
    private Map<String, Long> monthlyRewards;
    private Long totalRewards;
}
