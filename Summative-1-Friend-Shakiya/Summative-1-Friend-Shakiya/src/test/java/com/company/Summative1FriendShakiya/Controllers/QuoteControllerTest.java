package com.company.Summative1FriendShakiya.Controllers;


import com.company.Summative1FriendShakiya.Models.Quote;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
@RunWith(SpringRunner.class)
public class QuoteControllerTest
{
    @Autowired
    MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private List<Quote> quoteList;

    @Before
    public void setUp()
    {

    }
    @Test
    public void shouldReturnQuoteOnGetRequest() throws Exception
    {

        {
            String output = mapper.writeValueAsString(quoteList);
            mockMvc.perform(get("/quote"))
                    .andDo(print())
                    .andExpect(status().isOk());
        }

    }

}
