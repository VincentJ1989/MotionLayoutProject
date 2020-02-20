package com.example.motionlayoutproject.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

/**
 * Base DAO
 */
interface BaseDao<T> {
    @Insert
    suspend fun insert(obj: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg obj: T)

    @Delete
    suspend fun delete(vararg objs: T)

    @Update
    suspend fun update(obj: T)
}