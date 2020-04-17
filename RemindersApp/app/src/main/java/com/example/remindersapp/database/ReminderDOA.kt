package com.example.remindersapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.remindersapp.model.Reminder

/**
 * Basic CRUD operations
 */
@Dao
interface ReminderDOA {
    // We won't need Coroutines
    // Live data will take care of the process by using threads individually in the background
    @Query("SELECT * FROM reminderTable")
    fun getAllReminders() : LiveData<List<Reminder>>

    @Insert
    suspend fun insertReminder(reminder: Reminder)

    @Delete
    suspend fun deleteReminder(reminder: Reminder)

    @Update
    suspend fun updateReminder(reminder: Reminder)
}