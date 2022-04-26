package com.graphql.investment.service.controller;

import com.graphql.investment.service.config.QueryConfig;
import com.graphql.investment.service.service.GraphQLProvider;
import graphql.ExecutionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investment")
public class InvestmentController {

    private final GraphQLProvider graphQLProvider;
    private final QueryConfig queryConfig;

    public InvestmentController(GraphQLProvider graphQLProvider, QueryConfig queryConfig) {
        this.graphQLProvider = graphQLProvider;
        this.queryConfig = queryConfig;
    }

    @GetMapping("/internal")
    public ResponseEntity<Object> getAllInvestmentsForInternal() {
        ExecutionResult execute = graphQLProvider.getGraphQL().execute(queryConfig.getInternalQuery());
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }

    @GetMapping("/sales")
    public ResponseEntity<Object> getAllInvestmentsForSales() {
        ExecutionResult execute = graphQLProvider.getGraphQL().execute(queryConfig.getSalesQuery());
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }

    @GetMapping("/purchase")
    public ResponseEntity<Object> getAllInvestmentsForPurchase() {
        ExecutionResult execute = graphQLProvider.getGraphQL().execute(queryConfig.getPurchaseQuery());
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }

    @GetMapping("/internal/{id}")
    public ResponseEntity<Object> getInvestmentForInternal(@PathVariable("id") final Long id) {
        String query = String.format(queryConfig.getInternalByIdQuery(), id);
        ExecutionResult execute = graphQLProvider.getGraphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<Object> getInvestmentForSales(@PathVariable("id") final Long id) {
        String query = String.format(queryConfig.getSalesByIdQuery(), id);
        ExecutionResult execute = graphQLProvider.getGraphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }

    @GetMapping("/purchase/{id}")
    public ResponseEntity<Object> getInvestmentForPurchase(@PathVariable("id") final Long id) {
        String query = String.format(queryConfig.getPurchaseByIdQuery(), id);
        ExecutionResult execute = graphQLProvider.getGraphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
