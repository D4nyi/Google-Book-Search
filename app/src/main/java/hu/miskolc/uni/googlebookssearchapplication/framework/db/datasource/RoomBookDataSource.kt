package hu.miskolc.uni.googlebookssearchapplication.framework.db.datasource

import hu.miskolc.uni.core.data.BookDataSource
import hu.miskolc.uni.core.domain.Book
import hu.miskolc.uni.googlebookssearchapplication.framework.db.dao.AuthorRecordDao
import hu.miskolc.uni.googlebookssearchapplication.framework.db.dao.BookRecordDao
import hu.miskolc.uni.googlebookssearchapplication.framework.db.model.AuthorRecordMapper
import hu.miskolc.uni.googlebookssearchapplication.framework.db.model.BookRecordMapper

class RoomBookDataSource(
    private val bookDao: BookRecordDao,
    private val authorDao: AuthorRecordDao
) :
    BookDataSource {
    override suspend fun fetchBooks(query: String): List<Book> {
        val records = bookDao.fetchBooks("%${query}%")
        return records.map { BookRecordMapper.mapToBook(it) }
    }

    override suspend fun saveBooks(books: List<Book>) {
        books.forEach { book ->
            val bookRecord = BookRecordMapper.mapFromBook(book)
            val newBookId = bookDao.insertBook(bookRecord)

            val authors =
                book.authors?.map { AuthorRecordMapper.mapFromAuthor(it, newBookId) }?.apply {
                    authorDao.insertAuthors(this)
                }
        }
    }
}