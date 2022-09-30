package com.company.Summative1FriendShakiya.Controllers;

import com.company.Summative1FriendShakiya.Models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteController
{
    private List<Quote> quoteList;
    private static int idCounter = 1;

    public static int randomInt()
    {
        Random intR = new Random();
        int num;
        num = intR.nextInt(10);
        return num;
    }

    public QuoteController()
    {
        quoteList = new ArrayList<>();

        quoteList.add(new Quote("John Bloom","Que Sera Sera",idCounter++));
        quoteList.add(new Quote("Perri Frank","Yolo", idCounter++));
        quoteList.add(new Quote("Nelly Thorn","Chicken is superior, superiority is chicken", idCounter++));
        quoteList.add(new Quote("Yanny Lyle","Well all have great minds, teh main thing is to use it well", idCounter++));
        quoteList.add(new Quote("Rex Flank","Quitting is for losers, nobody should be a loser.", idCounter++));
        quoteList.add(new Quote("Justin Dildy","Actions speak louder than words.", idCounter++));
        quoteList.add(new Quote("Patsy Serrano","Practice makes perfect.",idCounter++));
        quoteList.add(new Quote("Shakiya Friend","Push past your limits!", idCounter++));
        quoteList.add(new Quote("Lilly Fail","I may be a fail, but I fail the best.", idCounter++));
        quoteList.add(new Quote("Mahogany Black","Life without color, isn't life.",idCounter++));

    }
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public List<String> getQuotes()
    {
        List<String> foundQuote = new ArrayList<>();
        int Random = randomInt();
        foundQuote.add(quoteList.get(Random).getAuthor());
        foundQuote.add(quoteList.get(Random).getQuote());
        return foundQuote;
    }

}
