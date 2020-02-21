package com.example.motionlayoutproject.data

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_2_3: Migration = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // TODO do db update
//        database.execSQL(
//            "ALTER TABLE users "
//                    + " ADD COLUMN last_update INTEGER"
//        )
    }
}