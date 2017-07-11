package com.acme.a3csci3130;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

/**
 * Created by alexa on 2017-07-10.
 */

public class DetailViewTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void verifyItemsAreShown() {
        ElapsedTimeIdlingResource idlingResource = new ElapsedTimeIdlingResource(3000);
        Espresso.registerIdlingResources(idlingResource);
        Actions.clickFirstOnList(R.id.listView);
        Espresso.unregisterIdlingResources(idlingResource);
        Actions.textIsVisible("Fishy Fishengton");
        Actions.textIsVisible("NL");
        Actions.textIsVisible("987654321");
        Espresso.closeSoftKeyboard();
        Actions.textIsVisible("Distributor");
        Espresso.closeSoftKeyboard();
        Actions.textIsVisible("Pie St.");
        Espresso.closeSoftKeyboard();
    }

    @Test
    public void erase() {
        verifyItemsAreShown();
        Actions.clickItemWithId(R.id.deleteButton);
        Actions.textIsNotVisible("Fishy Fishengton", R.id.detailname);
    }

}
