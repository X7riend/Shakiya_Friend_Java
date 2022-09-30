package com.company.Summative1FriendShakiya.Controllers;

import com.company.Summative1FriendShakiya.Models.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AnswerControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnAnswerOnPostRequestWithQuestion() throws Exception
    {
        Answer inputAnswer = new Answer("Today is the day.","When should I start pursing my goals?",1);

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(inputAnswer);

        String outputJson = mapper.writeValueAsString(inputAnswer);

        // ACT
        mockMvc.perform
                        (
                post("/magic")
                .content(outputJson)
                .contentType(MediaType.APPLICATION_JSON)
                        )

                .andDo(print())
                .andExpect(status().isCreated());

    }
}
