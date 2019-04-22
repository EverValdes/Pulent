package com.example.pulent

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.rule.ActivityTestRule

import org.junit.Test

import androidx.test.espresso.assertion.ViewAssertions.matches

import androidx.test.espresso.matcher.ViewMatchers

import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.pulent.ui.view.MainActivity

import org.junit.Assert.*
import org.junit.Rule

class ExampleInstrumentedTest {

    @JvmField
    @Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.pulent", appContext.packageName)
    }

    @Test
    fun loadingIndicatorAppearance() {
        onView(withId(R.id.searchTextInputEditText)).perform(typeText("Walk"))
        onView(withId(R.id.searchButton)).perform(click())

        onView(withId(R.id.loadingIndicator)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
    }

    @Test
    fun searchEmptyError() {
        onView(withId(R.id.searchButton)).perform(click())

        onView(withId(R.id.loadingIndicator)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
    }

}
