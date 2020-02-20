package com.example.motionlayoutproject.data

import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query(
        "SELECT * FROM user WHERE first_name LIKE :first AND " +
                "last_name LIKE :last LIMIT 1"
    )
    fun findByName(first: String, last: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

    @Update
    fun update(vararg users: User)

    @Query("SELECT * FROM user WHERE id > :minAge")
    fun loadAllUsersOlderThan(minAge: Int): Array<User>

    // 智获取部分数据
    @Query("SELECT first_name, last_name FROM user")
    fun loadFullName(): List<NameTuple>

    // 事务
    @Transaction
    fun setLoggedInUser(loggedInUser: User) {
        delete(loggedInUser)
        insertAll(loggedInUser)
    }
}