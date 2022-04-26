package com.graphql.demo.controller;

import com.graphql.demo.service.GraphQLService;
import graphql.ExecutionResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class InvestmentController {

    private final GraphQLService graphQLService;

    @GetMapping("/investments")
    public ResponseEntity<Object> getInvestments(
            @RequestParam(name = "type", required = false, defaultValue = "all") String type
    ) {
        ExecutionResult result = graphQLService.executeQuery(
                type,
                new HashMap<>()
        );
        return ResponseEntity.ok(result);
    }

    @GetMapping("/investments/{id}")
    public ResponseEntity<Object> getInvestment(
            @PathVariable("id") long id
    ) {
        ExecutionResult result = graphQLService.executeQuery(
                "investment-by-id",
                Map.of("id", id)
        );
        return ResponseEntity.ok(result);
    }
}
