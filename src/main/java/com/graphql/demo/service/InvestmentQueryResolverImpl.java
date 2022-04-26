package com.graphql.demo.service;

import com.graphql.demo.entity.Investment;
import com.graphql.demo.repository.InvestmentRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class InvestmentQueryResolverImpl implements GraphQLQueryResolver, InvestmentQueryResolver {

    private final InvestmentRepository repository;

    @Override
    public List<Investment> findAllInvestments() {
        return repository.findAll();
    }

    @Override
    public Investment findInvestmentById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID " + id + " not found"));
    }
}
