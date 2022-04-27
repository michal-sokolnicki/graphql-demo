package com.graphql.investment.service.controller;

import com.graphql.investment.service.service.GraphQLService;
import graphql.ExecutionResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class InvestmentController {

    private final GraphQLService graphQLService;

    @GetMapping("/investments")
    public ResponseEntity<Object> getInvestments(@RequestParam(name = "type", required = false,
            defaultValue = "all") String type) {
        ExecutionResult result = graphQLService.executeQuery(type, Collections.emptyMap());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/investments/{id}")
    public ResponseEntity<Object> getInvestment(@PathVariable("id") long id) {
        ExecutionResult result = graphQLService.executeQuery("investment-by-id", Map.of("id", id));
        return ResponseEntity.ok(result);
    }
}
