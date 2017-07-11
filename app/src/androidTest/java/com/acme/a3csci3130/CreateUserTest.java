package com.acme.a3csci3130;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by alexa on 2017-07-10.
 */
@RunWith(AndroidJUnit4.class)
public class CreateUserTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void createUserTest() {
        Actions.clickItemWithId(R.id.submitButton);
        Actions.type(R.id.address, "Pie St.");
        Actions.type(R.id.primary_business, "Distributor");
        Actions.type(R.id.name, "Fishy Fishengton");
        Actions.type(R.id.province, "NL");
        Actions.type(R.id.business_number, "987654321");
        Espresso.closeSoftKeyboard();
        Actions.clickItemWithId(R.id.submitButton);
    }
}
