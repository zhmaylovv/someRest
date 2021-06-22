package ru.sber.part3Rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ContractorApplicationTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    void checkRestAlive() throws Exception {
        this.mockMvc.perform(get("/contractor"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"));

    }
    @Test
    void checkAddedData() throws Exception {

        String json = "{\"name\": \"Frodo Baggins\", \"inn\": 123, \"kpp\": 321, \"bik\": 456, \"account\": \"23456\"}";
        this.mockMvc.perform(post("/contractor")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated());

        this.mockMvc.perform(get("/contractor/1"))
                .andDo(print())
                .andExpect(content().string(containsString("MR.Frodo Baggins")));
    }
}
