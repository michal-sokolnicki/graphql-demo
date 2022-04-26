package com.graphql.demo;

import com.graphql.demo.entity.Investment;
import com.graphql.demo.repository.InvestmentRepository;
import com.graphql.demo.service.InvestmentQueryResolverImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InvestmentQueryResolverImplTest {

    @Mock
    private InvestmentRepository investmentRepository;

    @InjectMocks
    private InvestmentQueryResolverImpl investmentQueryResolver;

    @Test
    void findAllInvestments() {
        // given
        when(investmentRepository.findAll()).thenReturn(List.of(
                Investment.builder()
                        .investmentId(1L)
                        .email("test@test.com")
                        .build()
        ));

        // when
        List<Investment> result = investmentQueryResolver.findAllInvestments();

        // then
        assertThat(result).isNotNull().isNotEmpty();
        assertThat(result.get(0).getInvestmentId()).isEqualTo(1L);
        assertThat(result.get(0).getEmail()).isEqualTo("test@test.com");
    }

    @Test
    void findInvestmentById() {
        // given
        long id = 1L;
        when(investmentRepository.findById(id)).thenReturn(Optional.of(
                Investment.builder()
                        .investmentId(1L)
                        .email("test@test.com")
                        .build()
        ));

        // when
        Investment result = investmentQueryResolver.findInvestmentById(id);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getInvestmentId()).isEqualTo(1L);
        assertThat(result.getEmail()).isEqualTo("test@test.com");
    }
}
