package com.techreturners.apilab1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class CoffeeControllerTests {

    @Autowired
    private MockMvc mockMvcController;

    @Test
    public void testGetCoffeeLover() throws Exception {
        //Arrange, Act and Assert chained within the following statements
        String expectedContent = "I like coffee!";

        //Make a GET request to the '/coffeelover' endpoint
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffeelover"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testGetCoffeeWithoutRequestParams() throws Exception {
        //Arrange, Act and Assert chained within the following statements
        String expectedContent = "latte";

        //Make a GET request to the '/coffee' endpoint
        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/coffee"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedContent));
    }

    @Test
    public void testGetCoffeeWithRequestParams() throws Exception {
        //Arrange, Act and Assert chained within the following statements
        String expectedContent = "cappuccino";

        //Make a GET request to the '/coffee' endpoint
        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/coffee").param("name", "cappuccino"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedContent));
    }

}
