package com.graphql.investment.service.service;

import com.graphql.investment.service.model.Investment;

import java.util.List;

public interface InvestmentQueryResolver {

    List<Investment> findAllInvestments();
    Investment findInvestmentById(long id);
}
