package br.com.footballManager.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@AutoConfigureMockMvc
@SpringBootTest
public class TeamsControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAllTeams() throws Exception{
        mockMvc.perform(get("/times"))
                .andExpect(status().isOk())
                .andExpect(content().json("{}") );
    }
}
