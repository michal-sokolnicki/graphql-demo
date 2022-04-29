package com.graphql.investment.service.service.impl;

import com.graphql.investment.service.model.Investment;
import com.graphql.investment.service.repository.InvestmentRepository;
import com.graphql.investment.service.service.InvestmentQueryResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class InvestmentQueryResolverImpl implements GraphQLQueryResolver, InvestmentQueryResolver {

    private final InvestmentRepository investmentRepository;

    @Override
    public List<Investment> findAllInvestments() {
        return investmentRepository.findAll();
    }

    @Override
    public Investment findInvestmentById(long id) {
        return investmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        MessageFormat.format("Investment with id: {0} not found", id)));
    }
}
