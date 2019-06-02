package com.forkosey.workout_tracker.ui.workout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.forkosey.workout_tracker.R
import com.forkosey.workout_tracker.domain.Workout

class WorkoutListAdapter(private val dataSet: Array<Workout>, val clickListener: (Workout) -> Unit) :
RecyclerView.Adapter<WorkoutListAdapter.WorkoutViewHolder>() {

    class WorkoutViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(workout: Workout, clickListener: (Workout) -> Unit) {
            view.findViewById<TextView>(R.id.name_edit_text).text = workout.name
            view.findViewById<TextView>(R.id.desc_edit_text).text = workout.description
            view.setOnClickListener { clickListener(workout) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.workout_list_item, parent, false)
        return WorkoutViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        holder.bind(dataSet[position], clickListener)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}