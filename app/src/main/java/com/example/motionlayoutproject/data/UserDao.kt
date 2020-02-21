package com.example.motionlayoutproject.data

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

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
    // 另一个用法是当一个QUERY返回的POJO带@Relation的对象或者是当前QUERY的返回结果实在太大了，
    // 避免数据库在查询期间又做了修改而引起的脏数据
    @Transaction
    suspend fun setLoggedInUser(loggedInUser: User) {
        delete(loggedInUser)
        insert(loggedInUser)
    }

    // LiveData---不用加suspend
    @Query("SELECT * FROM user")
    fun getAllByLiveData():LiveData<List<User>>


}