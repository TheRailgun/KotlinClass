package com.example.cookieclicker;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CookieClickerTest {

    @Rule
    public ActivityScenarioRule rule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void totalStartsAtZero() throws Exception {
        onView(withId(R.id.lblTotal))
                .check(matches(withText("0")));
    }

    @Test
    public void totalIncreasesWhenCookieClicked() throws Exception {
        onView(withId(R.id.paperclip))
                .perform(click());
        onView(withId(R.id.lblTotal))
                .check(matches(withText("1")));
    }
    @Test
    public void achieveHighScore() throws Exception {
        for (int i = 0; i < 100; i++) {
            onView(withId(R.id.paperclip))
                    .perform(click());
        }

        onView(withId(R.id.lblTotal))
                .check(matches(withText("100")));
    }
}
