package com.example.remindersapp.database

import android.content.Context
import com.example.remindersapp.model.Reminder

/**
 * In this class we perform actions on the database
 */
class ReminderRepository(context: Context) {

    private var reminderDao: ReminderDOA

    init {
        val reminderRoomDatabase = ReminderRoomDatabase.getDatabase(context)
        reminderDao = reminderRoomDatabase!!.reminderDao()
    }

    suspend fun getAllReminders(): List<Reminder> {
        return reminderDao.getAllReminders()
    }

    suspend fun insertReminder(reminder: Reminder) {
        reminderDao.insertReminder(reminder)
    }

    suspend fun deleteReminder(reminder: Reminder) {
        reminderDao.deleteReminder(reminder)
    }

    suspend fun updateReminder(reminder: Reminder) {
        reminderDao.updateReminder(reminder)
    }

}