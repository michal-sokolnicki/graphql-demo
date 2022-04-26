package com.graphql.investment.service.repository;

import com.graphql.investment.service.model.Investment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentRepository extends CrudRepository<Investment, Long> {}

