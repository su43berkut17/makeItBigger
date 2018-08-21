package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import com.su43berkut17.nanodegree.javalibtelljoke.TellJokeLib;

//name = "myApi",

/** An endpoint class we are exposing */
@Api(
        name = "returnJoke",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    /** A simple endpoint method that takes a name and says Hi back */


    @ApiMethod(name="returnJoke")
    public MyBean returnJoke() {
        MyBean response = new MyBean();

        //we get the joke
        TellJokeLib jokeProvider=new TellJokeLib();
        String jokeSend=jokeProvider.getJoke();

        response.setData("Hi, " + jokeSend);

        return response;
    }

}
