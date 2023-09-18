package br.com.footballManager.api;

import br.com.footballManager.api.players.entities.PlayerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;

@AutoConfigureMockMvc
@SpringBootTest
public class PlayerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createNewPlayer() throws Exception{
        PlayerEntity player = new PlayerEntity();

        player.setName("Neymar Jr.");
        String mockResult = new Gson().toJson(player);

        MvcResult result = mockMvc.perform(post("/jogador")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mockResult))
                .andExpect(status().isOk()).andReturn();

        String response = result.getResponse().getContentAsString();

        assert(response.equals(""));

    }

    @Test
    public void deleteAllPlayers() throws Exception{

        mockMvc.perform(delete("/jogador/all"))
                .andExpect(status().isOk());

    }
}
