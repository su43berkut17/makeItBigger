package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();

        response.setData("Hi, " + name);

        return response;
    }

    /*@ApiMethod(name="sayHi")
    public MyBean sayHi() {
        MyBean response = new MyBean();

        //we get the joke
        TellJokeLib jokeProvider=new TellJokeLib();
        String jokeSend=jokeProvider.getJoke();

        response.setData("Hi, " + jokeSend);

        return response;
    }*/

    /*@ApiMethod(name="getJoke")
    public MyBean GetJoke(){
        TellJokeLib jokeProvider=new TellJokeLib();
        String jokeSend=jokeProvider.getJoke();

        MyBean returnedBean;
        returnedBean=sayHi(jokeSend);

        //String returnedString=returnedBean.getData();

        return returnedBean;
    }*/
}
