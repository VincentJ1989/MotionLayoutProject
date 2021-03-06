package com.example.motionlayoutproject.data

import androidx.room.ColumnInfo

// 获取部分数据进行展示--不是数据中存的实体，不用加@Entity
// 只获取需要的信息，而不需要返回整个的数据Bean
data class NameTuple(
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
)