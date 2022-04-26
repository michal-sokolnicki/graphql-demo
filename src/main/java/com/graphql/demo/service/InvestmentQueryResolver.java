package com.graphql.demo.service;

import com.graphql.demo.entity.Investment;

import java.util.List;

public interface InvestmentQueryResolver {

    List<Investment> findAllInvestments();

    Investment findInvestmentById(long id);
}
