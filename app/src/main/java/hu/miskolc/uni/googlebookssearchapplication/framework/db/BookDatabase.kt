package hu.miskolc.uni.googlebookssearchapplication.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hu.miskolc.uni.googlebookssearchapplication.BuildConfig
import hu.miskolc.uni.googlebookssearchapplication.framework.db.dao.AuthorRecordDao
import hu.miskolc.uni.googlebookssearchapplication.framework.db.dao.BookRecordDao
import hu.miskolc.uni.googlebookssearchapplication.framework.db.model.AuthorRecord
import hu.miskolc.uni.googlebookssearchapplication.framework.db.model.BookRecord

@Database(
    entities = [
        BookRecord::class,
        AuthorRecord::class
    ],
    version = 1
)
abstract class BookDatabase : RoomDatabase() {
    abstract fun getBookRecordDao(): BookRecordDao
    abstract fun getAuthorRecordDao(): AuthorRecordDao

    companion object {

        private lateinit var INSTANCE: RoomDatabase
        private const val DATABASE_NAME = BuildConfig.APPLICATION_ID + ".db"

        fun getInstance(context: Context): RoomDatabase {
            if (!this::INSTANCE.isInitialized) {
                INSTANCE = createInstance(context)
            }
            return INSTANCE
        }

        private fun createInstance(context: Context): BookDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                BookDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}