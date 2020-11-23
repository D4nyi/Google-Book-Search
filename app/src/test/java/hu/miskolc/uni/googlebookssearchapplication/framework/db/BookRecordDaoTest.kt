package hu.miskolc.uni.googlebookssearchapplication.framework.db

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import hu.miskolc.uni.googlebookssearchapplication.framework.db.model.BookRecord
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class BookRecordDaoTest {

    private lateinit var bookDb: BookDatabase

    @Before
    fun setUp() {
        bookDb = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            BookDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()
    }

    @After
    fun tearDown() {
        bookDb.close()
    }

    @Test
    fun insertBookTest() = runBlocking {
        val toInsert = BookRecord(
            1,
            "HP",
            "JKR",
            "1998.10.10",
            "HP & Stone",
            330,
            8.4f,
            10_000,
            null,
            "English",
            null,
            null,
            null
        )
        bookDb.getBookRecordDao().insertBook(toInsert)

        val hpBook = bookDb.getBookRecordDao().fetchBooks()
        Assert.assertTrue(hpBook.isNotEmpty())
        Assert.assertFalse(hpBook.isEmpty())
        Assert.assertEquals(hpBook.size, 1)
        Assert.assertEquals(hpBook[1].book.id, 1)

    }
}