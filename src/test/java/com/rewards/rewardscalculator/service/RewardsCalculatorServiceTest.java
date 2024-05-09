package com.rewards.rewardscalculator.service;

import com.rewards.rewardscalculator.dto.RewardsDto;
import com.rewards.rewardscalculator.model.CustomerTransaction;
import com.rewards.rewardscalculator.repository.CustomerTransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class RewardsCalculatorServiceTest {

    @InjectMocks
    RewardsCalculatorService rewardsCalculatorService;
    @Mock
    CustomerTransactionRepository customerTransactionRepository;

    @Test
    public void test_calculateRewards() {

        List<CustomerTransaction> transactionList = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();


        CustomerTransaction t1 = new CustomerTransaction();
        t1.setCustomerId(1L);
        t1.setTransactionAmount(120);
        t1.setTransactionId(1L);
        t1.setTransactionDate(Timestamp.valueOf(now));

        transactionList.add(t1);

        when(customerTransactionRepository.findAllByTransactionDate(anyLong(), anyInt(), anyInt())).thenReturn(transactionList);

        RewardsDto rewards = rewardsCalculatorService.calculateRewardsForCustomerId(1L);
        assertThat(rewards).isNotNull();
        assertThat(rewards.getTotalRewards()).isEqualTo(270L);

    }
}