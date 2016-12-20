package com.example.ctest.ui.game

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.annotation.VisibleForTesting
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.view.View.GONE
import android.widget.Toast
import com.example.ctest.R
import com.example.ctest.data.GameUnit
import com.example.ctest.databinding.ActivityPlayBinding
import java.util.*

class PlayActivity : AppCompatActivity(), PlayContract.View {
    lateinit private var binding : ActivityPlayBinding
    lateinit private var presenter : PlayContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_play)

        presenter = PlayPresenter(this)
    }

    override fun onStart() {
        super.onStart()

        presenter.onViewAttached()
    }

    override fun onResume() {
        super.onResume()

        binding.playButton.setOnClickListener {v -> onPlayClick(v)}

        val manager = GridLayoutManager(this, 4)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = manager
    }

    override fun onPause() {
        super.onPause()

        binding.playButton.setOnClickListener {}
    }

    override fun onStop() {
        super.onStop()

        presenter.onViewDetached()
    }

    override fun onDataGenerated(list: List<GameUnit>) {
        val adapter = PlayAdapter(list)
        binding.recyclerView.adapter = adapter
    }

    override fun onTurnMade(index: Int) {
        binding.recyclerView.adapter.notifyItemChanged(index)
    }

    fun onPlayClick(view: View) : Unit {
        presenter.requestTurn()
    }

    /**
     * For testing purposes only!
     * @param presenter mocked presenter
     */
    fun setPresenter(presenter: PlayContract.Presenter){
        this@PlayActivity.presenter = presenter
    }
}


