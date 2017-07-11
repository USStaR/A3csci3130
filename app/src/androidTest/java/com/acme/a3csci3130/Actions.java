package com.acme.a3csci3130;

import android.support.test.espresso.matcher.ViewMatchers;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.not;

/**
 * Created by alexa on 2017-07-10.
 */

public class Actions {

    static void textIsVisible(String text) {
        onView(allOf(withText(text), isDisplayed())).perform(click());
    }

    static void textIsNotVisible(String text, int id) {
        onView(allOf(not(allOf(withText(text), isDisplayed())), withId(id))).perform(click());
    }

    static void textInListIsVisible(String text, int listId, int position) {
        onData(anything())
                .inAdapterView(ViewMatchers.withId(listId))
                .atPosition(position)
                .check(matches(hasToString(containsString(text))));
    }

    static void type(int id, String text) {
        onView(withId(id)).perform(typeText(text));
    }

    static void clickFirstOnList(int listId) {
        onData(anything())
                .inAdapterView(withId(listId))
                .atPosition(0)
                .perform(click());
    }

    static void clickItemWithId(int id) {
        onView(withId(id)).perform(click());
    }

}
