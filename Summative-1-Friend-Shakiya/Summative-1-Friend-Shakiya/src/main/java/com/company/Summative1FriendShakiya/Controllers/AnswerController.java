package com.company.Summative1FriendShakiya.Controllers;
import com.company.Summative1FriendShakiya.Models.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController

public class AnswerController
{
    //Create a list and an ID counter for the Answers in the answer list.
    private List<Answer> answerList;
    private static int idCounter = 1;


    // Create a random integer using a Random.
    public static int randomInt()
    {
        Random intR = new Random();
        int num;
        num = intR.nextInt(6);
        return num;
    }

    public AnswerController()
    {
        // Add data answers to answer list using constructors
        answerList = new ArrayList<>();
        answerList.add(new Answer("Life is unpredictable.","Why do my plans always fall through?",idCounter++));
        answerList.add(new Answer("You are enough.","Will I ever be enough?",idCounter++));
        answerList.add(new Answer("The weather today is Sunny with 0% precipitation.","What is the weather?",idCounter++));
        answerList.add(new Answer("You should go on a date.","Im bored with life, what should I do?",idCounter++));
        answerList.add(new Answer("You will pass.","How will I do on this test?",idCounter++));
        answerList.add(new Answer("They were unaware.","Did they purposefully hurt my feelings?",idCounter++));
    }
//    Thought the user was inputting a question
//    @RequestMapping(value = "/magic/{question}", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public String getMagicAnswer (@PathVariable String question)
//    {
//        return answerList.get(randomInt()).getAnswer();
//    }
    // Use a post method to return an answer
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public String getMagicAnswer ()
    {
        return answerList.get(randomInt()).getAnswer();
    }
}
