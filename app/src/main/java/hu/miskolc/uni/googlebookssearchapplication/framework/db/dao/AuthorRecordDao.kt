package hu.miskolc.uni.googlebookssearchapplication.framework.db.dao

import androidx.room.*
import hu.miskolc.uni.googlebookssearchapplication.framework.db.model.AuthorRecord

@Dao
interface AuthorRecordDao {

    @Insert
    suspend fun insertAuthor(author: AuthorRecord): Long

    @Insert
    suspend fun insertAuthors(authors: List<AuthorRecord>): List<Long>

    @Update
    suspend fun updateAuthor(author: AuthorRecord)

    @Delete
    suspend fun deleteAuthor(author: AuthorRecord)

    @Query("SELECT * from author")
    suspend fun fetchAuthors(): List<AuthorRecord>

    @Query("SELECT * from author where bookId = :bookId")
    suspend fun fetchAuthors(bookId: Long): List<AuthorRecord>
}