package com.example.motionlayoutproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.motionlayoutproject.utilities.DATABASE_NAME

@Database(
    entities = [User::class],
    views = [UserDetail::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            val db = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                DATABASE_NAME
            ).addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    // 创建的时候执行--异步执行!!!
                }
            })
                .fallbackToDestructiveMigration()//missing migration paths ,will remove all data in mobile
                //.fallbackToDestructiveMigrationFrom(3,4)// 表示仅当从版本3、4等迁移到下个版本时出现错误才会回清数据重建数据库
                //.fallbackToDestructiveMigrationOnDowngrade()// 表示仅当降级不成功(Migration不可用)时，数据库才会清空重建
                //.addMigrations(MIGRATION_2_3) // 有配置升级path--可以配置多个vargs
                .build()

            return db
        }
    }
}
