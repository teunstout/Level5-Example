package com.example.remindersapp.database

import androidx.room.*
import com.example.remindersapp.model.Reminder

/**
 * Basic CRUD operations
 */
@Dao
interface ReminderDOA {
    @Query("SELECT * FROM reminderTable")
    suspend fun getAllReminders() : List<Reminder>

    @Insert
    suspend fun insertReminder(reminder: Reminder)

    @Delete
    suspend fun deleteReminder(reminder: Reminder)

    @Update
    suspend fun updateReminder(reminder: Reminder)
}