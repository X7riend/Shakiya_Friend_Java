package com.company.Summative1FriendShakiya.Controllers;

import com.company.Summative1FriendShakiya.Models.Definition;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class DefinitionControllerTest
{
    @Autowired
    MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private List<Definition> definitionList;

    @Before
    public void setUp()
    {

    }


    @Test
    public void shouldReturnDefinitionOnGetRequest() throws Exception
    {
        String output = mapper.writeValueAsString(definitionList);
        mockMvc.perform(get("/word"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
