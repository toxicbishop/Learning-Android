package com.example.task7

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "UserPreferences.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_USERS = "users"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_EMAIL = "email"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = ("CREATE TABLE $TABLE_USERS (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_EMAIL TEXT)")
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }

    // Insert user data
    fun saveUser(name: String, email: String): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
            put(COLUMN_EMAIL, email)
        }
        val result = db.insert(TABLE_USERS, null, values)
        db.close()
        return result
    }

    // Retrieve the latest user
    fun getLatestUser(): Pair<String, String>? {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_USERS ORDER BY $COLUMN_ID DESC LIMIT 1", null)
        
        var user: Pair<String, String>? = null
        if (cursor.moveToFirst()) {
            val name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME))
            val email = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL))
            user = Pair(name, email)
        }
        cursor.close()
        db.close()
        return user
    }
}
