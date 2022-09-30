package com.company.Summative1FriendShakiya.Controllers;

import com.company.Summative1FriendShakiya.Models.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

import java.util.ArrayList;
import java.util.List;
@RestController


public class DefinitionController
{
    public static int randomInt()
    {
        Random intR = new Random();
        int num;
        num = intR.nextInt(10);
        return num;
    }
    private static int idCounter = 1;
    private List<Definition> definitionList;
    public DefinitionController()
    {
        definitionList = new ArrayList<>();
        definitionList.add(new Definition("Sassy","distinctively smart and stylish",idCounter++));
        definitionList.add(new Definition("Effuse","to pour forth",idCounter++));
        definitionList.add(new Definition("Rend","to split or tear apart in pieces by violence",idCounter++));
        definitionList.add(new Definition("Phonic","pertaining to the nature of sound",idCounter++));
        definitionList.add(new Definition("Virtu","rare, curious, or aesthetic quality",idCounter++));
        definitionList.add(new Definition("Misty","filled or abounding with fog or mist",idCounter++));
        definitionList.add(new Definition("Chasm","a yawning hollow, as in Earth's surface",idCounter++));
        definitionList.add(new Definition("Fervor","ardor or intensity of feeling",idCounter++));
        definitionList.add(new Definition("Lingo","language",idCounter++));
        definitionList.add(new Definition("Befog","to confuse",idCounter++));
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    public List<String> getWords()

    {
        List<String> foundDefinition = new ArrayList<>();
        int Random = randomInt();
        foundDefinition.add(definitionList.get(Random).getWord());
        foundDefinition.add(definitionList.get(Random).getDefinition());
        return foundDefinition;
    }
}
