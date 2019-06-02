package com.forkosey.workout_tracker.ui.workout.activity

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.forkosey.workout_tracker.R
import com.forkosey.workout_tracker.domain.Workout
import com.forkosey.workout_tracker.ui.workout.WorkoutListAdapter

import kotlinx.android.synthetic.main.activity_workout_list.*
import java.util.*

class WorkoutListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var workouts : Array<Workout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_list)

        this.title = "Workouts"

        seeding()

        setAddButton()
        setRecyclerView()
    }

    private fun seeding() {
        workouts = arrayOf(
            Workout(UUID.randomUUID().toString(), "Chest Workout", "Simple chest workout"),
            Workout(UUID.randomUUID().toString(), "Back Workout", "Simple back workout"),
            Workout(UUID.randomUUID().toString(), "Legs Workout", "Simple legs workout"),
            Workout(UUID.randomUUID().toString(), "Arms Workout", "Simple arms workout"),
            Workout(UUID.randomUUID().toString(), "Cardio Session", "Simple cardio session")
        )
    }

    private fun setRecyclerView() {
        fun onItemClick(workout: Workout) {
            val intent = Intent(this, WorkoutEditActivity::class.java)
            intent.putExtra("workout", workout)
            startActivity(intent)
        }

        viewManager = LinearLayoutManager(this)
        viewAdapter =
            WorkoutListAdapter(workouts) { workout -> onItemClick(workout) }

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager

            adapter = viewAdapter
        }
    }

    private fun setAddButton() {
        addButton.setOnClickListener { startActivity(Intent(this, WorkoutEditActivity::class.java)) }
    }

    //<editor-fold desc="Overrides">

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    //</editor-fold>
}
