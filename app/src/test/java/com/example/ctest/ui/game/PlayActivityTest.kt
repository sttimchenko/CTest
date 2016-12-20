package com.example.ctest.ui.game

import android.os.Build
import com.example.ctest.BuildConfig
import com.example.ctest.R
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.Robolectric
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config
import org.robolectric.util.ActivityController

@Config(constants = BuildConfig::class,  sdk = intArrayOf(Build.VERSION_CODES.LOLLIPOP))
@RunWith(RobolectricGradleTestRunner::class)
class PlayActivityTest{
    lateinit var presenter : PlayContract.Presenter
    lateinit var activity : PlayActivity
    lateinit var controller: ActivityController<PlayActivity>

    @Before
    fun onBefore(){
        controller = Robolectric.buildActivity(PlayActivity::class.java)
        presenter = Mockito.mock(PlayContract.Presenter::class.java)
    }

    @Test
    fun testOnStart(){
        activity = controller.create().get()

        activity.setPresenter(presenter)

        activity = controller.start().get()

        Mockito.verify(presenter).onViewAttached()
    }

    @Test
    fun testOnResume(){
        activity = controller.create().get()

        activity.setPresenter(presenter)

        activity = controller.resume().get()

        activity.findViewById(R.id.play_button).performClick()

        Mockito.verify(presenter).requestTurn()
    }
}