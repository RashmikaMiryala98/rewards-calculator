package com.rewards.rewardscalculator.controller;

import com.rewards.rewardscalculator.dto.RewardsDto;
import com.rewards.rewardscalculator.service.RewardsCalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@WebMvcTest(RewardsCalculatorController.class)
public class RewardsCalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RewardsCalculatorService rewardsCalculatorService;



    @Test
    void testGetRewardsForCustomerId() throws Exception {
        RewardsDto rewardsDto = new RewardsDto();
        rewardsDto.setCustomerId(1L);
        rewardsDto.setTotalRewards(100L);
        when(rewardsCalculatorService.calculateRewardsForCustomerId(anyLong())).thenReturn(rewardsDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/rewards/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalRewards").value(100));
    }


}
