package com.example.remindersapp.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.remindersapp.R
import com.example.remindersapp.model.Reminder
import kotlinx.android.synthetic.main.activity_add.*

import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_REMINDER = "EXTRA_REMINDER"

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        floatingActionButton.setOnClickListener { onSaveClick() }
    }

    /**
     * Save the reminder
     */
    private fun onSaveClick() {
        // start intent
        if (etAddReminder.text.toString().isNotBlank()) {
            val reminder = Reminder(etAddReminder.text.toString())
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_REMINDER, reminder)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this,"The reminder cannot be empty"
                , Toast.LENGTH_SHORT).show()
        }
    }
}

