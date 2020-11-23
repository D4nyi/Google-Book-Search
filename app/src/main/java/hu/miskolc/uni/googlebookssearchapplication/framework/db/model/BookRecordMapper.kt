package hu.miskolc.uni.googlebookssearchapplication.framework.db.model

import hu.miskolc.uni.core.domain.Book
import hu.miskolc.uni.core.domain.ImageLinks

class BookRecordMapper {
    companion object {
        fun mapToBook(record: BookRecordInfo): Book {
            return Book(
                record.book.title,
                record.authors.map { it.name },
                record.book.publisher,
                record.book.publishedDate,
                record.book.description,
                record.book.pageCount,
                record.book.averageRating,
                record.book.ratingsCount,
                ImageLinks(
                    record.book.imageLinks?.smallThumbnail,
                    record.book.imageLinks?.thumbnail
                ),
                record.book.language,
                record.book.previewLink,
                record.book.infoLink,
                record.book.canonicalVolumeLink
            )
        }

        fun mapFromBook(book: Book): BookRecord {
            return BookRecord(
                null,
                book.title,
                book.publisher,
                book.publishedDate,
                book.description,
                book.pageCount,
                book.averageRating,
                book.ratingsCount,
                ImageLinksRecord(book.imageLinks?.smallThumbnail, book.imageLinks?.thumbnail),
                book.language, book.previewLink,
                book.infoLink,
                book.canonicalVolumeLink
            )
        }
    }
}

class AuthorRecordMapper {
    companion object {
        fun mapToAuthor(record: AuthorRecord): String {
            return record.name
        }

        fun mapFromAuthor(author: String, bookId: Long?): AuthorRecord {
            return AuthorRecord(null, author, bookId)
        }
    }
}