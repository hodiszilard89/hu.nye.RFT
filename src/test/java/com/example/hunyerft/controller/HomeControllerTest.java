package com.example.hunyerft.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = HomeController.class)
@AutoConfigureMockMvc
@WebAppConfiguration
public class HomeControllerTest {


    @InjectMocks
    private HomeControllerTest controller;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
    }

    @Test
    public void testGoHome() throws Exception {


        String url = "/gohome";
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get(url))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String responseAsJson = "some expected response";

        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(),
                responseAsJson, "response does not match");

        // verify the calls
    }

    @Test
    public void testRoot() throws Exception {


        String url = "/";
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get(url))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String responseAsJson = "some expected response";

        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(),
                responseAsJson, "response does not match");

        // verify the calls
    }

    @Test
    public void testHallgato() throws Exception {


        String url = "/hallgato";
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get(url))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String responseAsJson = "some expected response";

        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(),
                responseAsJson, "response does not match");

        // verify the calls
    }

    @Test
    public void testOktato() throws Exception {


        String url = "/oktato";
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get(url))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String responseAsJson = "some expected response";

        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(),
                responseAsJson, "response does not match");

        // verify the calls
    }
}


