package com.graphql.demo.repository;

import com.graphql.demo.entity.Investment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentRepository extends CrudRepository<Investment, Long> {}
