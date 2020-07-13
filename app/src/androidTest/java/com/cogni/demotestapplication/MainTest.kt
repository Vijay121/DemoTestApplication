package com.cogni.demotestapplication

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainTest {

   /* @Test
    fun testEvent() {
        val scenario = launchActivity<MainTest>()
        scenario.recreate()
    }

    @Test
    fun testRecreateEvent(){
        val scenario = launchActivity<MainActivity>()
        scenario.onActivity { activity ->
            startActivity(Intent(activity, MainActivity::class.java))
        }
        onView(withId(R.id.user_recyclerview)).perform(click())
    }
  @Test fun testEvent() {
      val scenario = launchActivity<MainActivity>()
      scenario.onActivity { activity ->
          activity.handleSwipeToRefresh()
      }
  }*/
}