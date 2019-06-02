package com.forkosey.workout_tracker.ui.workout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.forkosey.workout_tracker.R
import com.forkosey.workout_tracker.domain.Workout

class WorkoutEditActivity : AppCompatActivity() {

    private var workout: Workout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_edit)

        workout = intent?.extras?.get("workout") as Workout?

        title = workout?.name ?: "New Workout"
        //findViewById<TextView>(R.id.id_edit_text).text = workout?.id ?: "No data for now"
        findViewById<TextView>(R.id.name_edit_text).text = workout?.name ?: ""
        findViewById<TextView>(R.id.desc_edit_text).text = workout?.description ?: ""
    }
}
