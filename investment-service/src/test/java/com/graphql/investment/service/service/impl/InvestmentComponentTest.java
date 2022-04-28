package com.graphql.investment.service.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InvestmentComponentTest {

    private static final String INVESTMENTS_SUB_PATH = "v1/investments";

    @Autowired
    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    @Test
    void findAllInvestments() throws Exception {
        // when
        var result = mockMvc.perform(
                MockMvcRequestBuilders
                        .get(String.format(
                                "http://localhost:%s/%s?type=wire",
                                port,
                                INVESTMENTS_SUB_PATH
                        )).accept(MediaType.APPLICATION_JSON_VALUE)
        ).andDo(print());

        // then
        result.andExpect(status().isOk())
                .andExpect(jsonPath(
                        "$.data.findAllInvestments[0].investmentId",
                        greaterThan(0L),
                        Long.class)
                )
                .andExpect(jsonPath(
                        "$.data.findAllInvestments[0].email",
                        equalTo("directinvestor@test.com"),
                        String.class)
                );
    }

    @Test
    void findAllWireInvestments() throws Exception {
        // when
        var result = mockMvc.perform(
                MockMvcRequestBuilders
                        .get(String.format(
                                "http://localhost:%s/%s?type=wire",
                                port,
                                INVESTMENTS_SUB_PATH
                        )).accept(MediaType.APPLICATION_JSON_VALUE)
        ).andDo(print());

        // then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.findAllInvestments[0].bankName").doesNotExist())
                .andExpect(jsonPath("$.data.findAllInvestments[0].bankAba").doesNotExist())
                .andExpect(jsonPath(
                        "$.data.findAllInvestments[0].fundName",
                        equalTo("FakeFund"),
                        String.class)
                );
    }

    @Test
    void findInvestmentById() throws Exception {
        // when
        var id = 1L;
        var result = mockMvc.perform(
                MockMvcRequestBuilders
                        .get(String.format(
                                "http://localhost:%s/%s/%d",
                                port,
                                INVESTMENTS_SUB_PATH,
                                id
                        )).accept(MediaType.APPLICATION_JSON_VALUE)
        ).andDo(print());

        // then
        result.andExpect(status().isOk())
                .andExpect(jsonPath(
                        "$.data.findInvestmentById.investmentId",
                        greaterThan(0L),
                        Long.class)
                )
                .andExpect(jsonPath(
                        "$.data.findInvestmentById.email",
                        equalTo("directinvestor@test.com"),
                        String.class)
                );
    }
}
