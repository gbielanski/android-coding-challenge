package com.shiftkey.codingchallenge.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shiftkey.codingchallenge.R
import com.shiftkey.codingchallenge.domain.ShiftItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
internal class MainActivity : AppCompatActivity(), ShiftClickListener {
    private val shiftsViewModel: ShiftsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shiftItemAdapter = ShiftItemAdapter(shiftClickListener = this)

        findViewById<RecyclerView>(R.id.recycler).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = shiftItemAdapter
        }

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                shiftsViewModel.uiState.collectLatest { state ->
                    shiftItemAdapter.items = state.shifts
                    shiftItemAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onShiftClicked(item: ShiftItem) {
        val intent = Intent(this, DetailsActivity::class.java)
        startActivity(intent)
    }

}

