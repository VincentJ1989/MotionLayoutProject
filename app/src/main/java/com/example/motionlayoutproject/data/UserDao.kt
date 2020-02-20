package com.example.motionlayoutproject.data

import androidx.room.*

@Dao
interface UserDao :BaseDao<User> {
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): List<User>

    @Query(
        "SELECT * FROM user WHERE first_name LIKE :first AND " +
                "last_name LIKE :last LIMIT 1"
    )
    suspend fun findByName(first: String, last: String): User

    @Query("SELECT * FROM user WHERE id > :minAge")
    suspend fun loadAllUsersOlderThan(minAge: Int): Array<User>

    // 智获取部分数据
    @Query("SELECT first_name, last_name FROM user")
    suspend fun loadFullName(): List<NameTuple>

    // 事务
    @Transaction
    suspend fun setLoggedInUser(loggedInUser: User) {
        delete(loggedInUser)
        insert(loggedInUser)
    }
}