package hu.miskolc.uni.googlebookssearchapplication.framework.db.dao

import androidx.room.*
import hu.miskolc.uni.googlebookssearchapplication.framework.db.model.BookRecord
import hu.miskolc.uni.googlebookssearchapplication.framework.db.model.BookRecordInfo

@Dao
interface BookRecordDao {

    @Insert
    suspend fun insertBook(record: BookRecord): Long

    @Update
    suspend fun updateBook(record: BookRecord)

    @Delete
    suspend fun deleteBook(record: BookRecord)

    @Query("SELECT * from BOOK")
    suspend fun fetchBooks(): List<BookRecordInfo>

    @Query("SELECT * from BOOK where title LIKE :query  ")
    suspend fun fetchBooks(query: String): List<BookRecordInfo>
}