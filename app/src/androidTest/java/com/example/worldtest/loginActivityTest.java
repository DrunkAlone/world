package com.example.worldtest;

import android.widget.EditText;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.robotium.solo.Solo;

import org.junit.After;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class loginActivityTest {

    @Rule
    public ActivityTestRule<loginActivity> activityTestRule =
            new ActivityTestRule<>(loginActivity.class ,false, true);
    private Solo solo;

    @Before
    public void setUp() throws Exception {
        solo = new Solo(InstrumentationRegistry.getInstrumentation(),
                activityTestRule.getActivity());
    }

    @After
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    @Test
    public void testLogin() throws Exception {
        EditText name = (EditText) solo.getView("et_loginactivity_username");
        EditText pwd = (EditText) solo.getView("et_loginactivity_password");
        solo.enterText(name, ""); //清空
        solo.enterText(pwd, ""); //清空
        solo.enterText(name, "123988");
        solo.enterText(pwd, "123988aaa");
        solo.clickOnView(solo.getView("bt_loginactivity_login"));
        boolean result = solo.waitForActivity(Main2Activity.class, 1000);
        Assert.assertEquals(true, result);
    }

}