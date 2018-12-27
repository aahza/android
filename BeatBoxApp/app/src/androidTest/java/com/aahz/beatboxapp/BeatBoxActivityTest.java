package com.aahz.beatboxapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.*;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.contrib.RecyclerViewActions.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class BeatBoxActivityTest {

    @Rule
    public ActivityTestRule<BeatBoxActivity> mActivityRule = new ActivityTestRule<>(BeatBoxActivity.class);

    @Test
    public void showsFirstName() {
        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.<RecyclerView.ViewHolder>actionOnItemAtPosition(0, click()));
                //.check(matches(withText("65_CJIPIE")));

        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.<RecyclerView.ViewHolder>actionOnItemAtPosition(1, click()));
    }
}
