package com.udacity.gradle.builditbigger;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.IdlingResource.IdlingResourceAsync;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class AsyncTest {
    @Rule public ActivityTestRule<MainActivity> mActivityTestRule
            =new ActivityTestRule<>(MainActivity.class);

    private IdlingResourceAsync mIdlingResource;

    @Before
    public void registerIdlingResource(){
        mIdlingResource=mActivityTestRule.getActivity().getmIdlingResourceAsync();

        Espresso.registerIdlingResources(mIdlingResource);
    }

    @Test
    public void pressButton(){
        //we press the button
        onView(withId(R.id.instructions_text_view)).perform(click());

        //we need to wait for the resource to load before checking the test
        onView(withId())

        //we open the 1st item
        /*onView(withId())


        onView(withId(R.id.rvRecipes)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));

        onView(withId(R.id.rvRecipeSteps)).check(matches(hasDescendant(withText("Recipe Introduction"))));

        //we open the ingredient section
        onView(withId(R.id.rvRecipeSteps)).perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));

        onView(withId(R.id.btn_next_step)).check(matches(withText("NEXT STEP")));*/
    }
}
