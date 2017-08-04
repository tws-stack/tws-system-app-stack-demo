package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ComputeServiceTest {
    @Configuration
    class ServiceConfiguration {
        @Bean
        public ComputeService getComputeService() {
            return new ComputeService();
        }
    }

    @Autowired
    private ComputeService computeService;

    @Test
    public void compute_service_should_return_compute_answer_when_input_two_number() throws Exception {
        assertThat(computeService.compute(1, 2)).isEqualTo(3);
    }

}


