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

        findViewById<TextView>(R.id.id_text_view).text = workout?.id ?: "No data for now"
        findViewById<TextView>(R.id.name_text_view).text = workout?.id ?: "No data for now"
        findViewById<TextView>(R.id.desc_text_view).text = workout?.id ?: "No data for now"
    }
}
