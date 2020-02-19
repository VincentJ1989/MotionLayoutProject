package com.example.motionlayoutproject.data

import androidx.room.*

// 嵌套类
data class Address(
    var street: String?,
    var state: String?,
    var city: String?,
    @ColumnInfo(name = "post_code") var postCode: Int
)

@Entity(
    // 设置外键
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["user_id"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.NO_ACTION
    )]
)
class Book(
    @PrimaryKey var bookId: Int,
    var title: String?,
    @ColumnInfo(name = "user_id") var userId: Int
)


@Entity(tableName = "user")
data class User(
    @PrimaryKey var id: Int = 0,
    @ColumnInfo(name = "first_name") var firstName: String? = "",
    @ColumnInfo(name = "last_name") var lastName: String? = "",
    @Ignore val age: Int = 0,
    @Embedded var address: Address? = null
) {
    companion object {
        fun DEFAULT_USER() = User(-1, "F", "L")
    }
}

// 多对多
@Entity
data class Playlist(
    @PrimaryKey var id: Int,
    var name: String?,
    var description: String?
)

@Entity
data class Song(
    @PrimaryKey var id: Int,
    val songName: String?,
    val artistName: String?
)

@Entity(
    tableName = "playlist_song_join",
    primaryKeys = ["playlistId", "songId"],
    foreignKeys = [
        ForeignKey(entity = Playlist::class, parentColumns = ["id"], childColumns = ["playlistId"]),
        ForeignKey(entity = Song::class, parentColumns = ["id"], childColumns = ["songId"])
    ]
)
data class PlaylistSongJoin(val playlistId: Int, val songId: Int)

// DatabaseView
/*建议使用3引号，这样数据库字段异常一下就可以发现*/
@DatabaseView(
    """
                SELECT * FROM user WHERE user.id = 1
        """
//        "SELECT user.id, user.name, user.departmentId,"
//                + "department.name AS departmentName FROM user " +
//                "INNER JOIN department ON user.departmentId = department.id"
)

@Entity
data class UserDetail(
    val id: Long,
    val name: String?,
    val departmentId: Long,
    val departmentName: String?
)
