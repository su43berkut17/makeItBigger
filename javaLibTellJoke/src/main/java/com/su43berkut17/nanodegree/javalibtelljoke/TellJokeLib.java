package com.su43berkut17.nanodegree.javalibtelljoke;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TellJokeLib {
    private static List<String> jokeList= Arrays.asList(
            "What’s the best thing about Switzerland? I don’t know, but the flag is a big plus!",
            "Can a kangaroo jump higher than a house? Of course, a house doesnt jump at all.",
            "Anton, do you think I’m a bad mother? My name is Paul.",
            "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",
            "Mom, where do tampons go? Where the babies come from, darling. In the stork?",
            "My wife suffers from a drinking problem. Oh is she an alcoholic? No, I am, but she’s the one who suffers.",
            "Coco Chanel once said that you should put perfume on places where you want to be kissed by a man. But hell does that burn!",
            "Doctor: Do you do sports? Patient: Does sex count? Doctor: Yes. Patient: Then no.",
            "Oh darling, since you’ve started dieting, you’ve become such a passionate kisser… What do you mean, passionate? I’m looking for food remains!",
            "You know how it is in life. One door closes – that means another door opens… Yeah, very nice, but you either fix that or I’m expecting a serious discount on that car!");

    public String getJoke(){
        //we create a random number to pick the joke
        Random rand = new Random();
        int number=rand.nextInt(10)+1;

        return jokeList.get(number);
    }
}
