package com.shiftkey.codingchallenge.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.ui.graphics.toArgb
import androidx.recyclerview.widget.RecyclerView
import com.shiftkey.codingchallenge.R
import com.shiftkey.codingchallenge.domain.ShiftItem
import com.shiftkey.codingchallenge.domain.toComposeColor

internal class ShiftItemAdapter(
    var items: List<ShiftItem> = listOf(),
    val itemClickListener: ShiftClickListener,
    val scrollListener: ShiftScrollListener,
) :
    RecyclerView.Adapter<ShiftItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
        if (position == items.size - 1) {
            scrollListener.onLastReached()
        }
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val startTime = itemView.findViewById<TextView>(R.id.startTime)
        private val endTime = itemView.findViewById<TextView>(R.id.endTime)
        private val skill = itemView.findViewById<TextView>(R.id.skill)
        private val facility = itemView.findViewById<TextView>(R.id.facility)

        init {
            itemView.setOnClickListener {
                itemClickListener.onShiftClicked(items[adapterPosition])
            }
        }

        fun bind(item: ShiftItem) = with(itemView) {
            startTime.text = item.normalizedStartTime
            endTime.text = item.normalizedEndTime
            skill.text = item.skill.name
            skill.setBackgroundColor(item.skill.color.toComposeColor().toArgb())
            facility.text = item.facilityType.name
            facility.setBackgroundColor(item.facilityType.color.toComposeColor().toArgb())
            setBackgroundColor(item.facilityType.color.toComposeColor().toArgb())
        }

    }
}
