package com.example.demo.controller;

import com.example.demo.service.ComputeService;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ComputeController.class)
public class ComputeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ComputeService computeService;

    @Test
    public void should_return_sum_answer() throws Exception {
        given(computeService.compute(1,2)).willReturn(3);

        this.mvc.perform(get("/compute?a=1&b=2"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(3)));
    }
}
