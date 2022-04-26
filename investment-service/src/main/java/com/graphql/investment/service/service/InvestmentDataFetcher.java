package com.graphql.investment.service.service;

import com.graphql.investment.service.model.Investment;
import com.graphql.investment.service.repository.InvestmentRepository;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InvestmentDataFetcher {

    private final InvestmentRepository investmentRepository;

    public InvestmentDataFetcher(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    public DataFetcher<List<Investment>> findAllInvestments() {
        return dataFetchingEnvironment -> StreamSupport.stream(investmentRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public DataFetcher<Investment> findInvestmentById() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");
            return investmentRepository.findById(Long.parseLong(id))
                    .orElseThrow(() -> new RuntimeException(MessageFormat.format("Document with id: {} not found", id)));
        };
    }
}
