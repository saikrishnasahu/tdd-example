package com.wipro.tddexample.controller;

import com.wipro.tddexample.service.TDDService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class TDDControllerTest {

    @Mock
    private TDDService tddService;

    @InjectMocks
    private TDDController tddController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(tddController)
                .build();
    }

    @Test
    public void testHelloWorld() throws Exception {

        when(tddService.helloWorld()).thenReturn("Hello");

        mockMvc.perform(get("/tdd"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello"));

        verify(tddService).helloWorld();
    }

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(get("/tdd/json")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Greetings")))
                .andExpect(jsonPath("$.value", is("Hello World")))
                .andExpect(jsonPath("$.*", hasSize(2)));
    }

    @Test
    public void testPost() throws Exception {
        String json = "{\n" +
                "  \"name\": \"Greetings\",\n" +
                "  \"value\": \"Hello World\"\n" +
                "}";
        mockMvc.perform(get("/tdd/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Greetings")))
                .andExpect(jsonPath("$.value", is("Hello World")))
                .andExpect(jsonPath("$.*", hasSize(2)));
    }
}
