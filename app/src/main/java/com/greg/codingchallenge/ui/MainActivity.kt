package com.greg.codingchallenge.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.greg.codingchallenge.R
import com.greg.codingchallenge.domain.ShiftItem
import com.greg.codingchallenge.ui.DetailsActivity.Companion.SHIFT_DETAILS
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
internal class MainActivity : AppCompatActivity(), ShiftClickListener, ShiftScrollListener {
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var errorView: TextView
    private val shiftsViewModel: ShiftsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.progressBar)
        recyclerView = findViewById(R.id.recycler)
        errorView = findViewById(R.id.error)

        val shiftItemAdapter = ShiftItemAdapter(itemClickListener = this, scrollListener = this)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = shiftItemAdapter
        }

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                shiftsViewModel.uiState.collectLatest { state ->
                    if (state.isLoading) {
                        progressBar.visibility = View.VISIBLE
                    } else {
                        progressBar.visibility = View.GONE
                        shiftItemAdapter.items = state.shifts
                        shiftItemAdapter.notifyDataSetChanged()
                    }

                    if (state.error.isNullOrEmpty().not()) {
                        errorView.text = state.error
                        errorView.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    } else {
                        errorView.visibility = View.GONE
                        recyclerView.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    override fun onShiftClicked(item: ShiftItem) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra(
                SHIFT_DETAILS, item
            )
        }
        startActivity(intent)
    }

    override fun onLastReached() {
        shiftsViewModel.lastReached()
    }

}

