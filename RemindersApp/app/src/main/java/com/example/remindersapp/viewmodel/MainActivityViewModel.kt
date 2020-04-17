package com.example.remindersapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.remindersapp.database.ReminderRepository
import com.example.remindersapp.model.Reminder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * We now put the business logic in here, so we separate it from the view
 */
class MainActivityViewModel(application: Application): AndroidViewModel(application) {
    private val ioScope = CoroutineScope(Dispatchers.IO) // Global variable for CorountineScope
    private val reminderRepository = ReminderRepository(application.applicationContext) // Get repository from application

    val reminders: LiveData<List<Reminder>> = reminderRepository.getAllReminders()

    fun insertReminder(reminder: Reminder){
        ioScope.launch {
            reminderRepository.insertReminder(reminder)
        }
    }

    fun deleteReminder(reminder: Reminder){
        ioScope.launch {
            reminderRepository.deleteReminder(reminder)
        }
    }

}