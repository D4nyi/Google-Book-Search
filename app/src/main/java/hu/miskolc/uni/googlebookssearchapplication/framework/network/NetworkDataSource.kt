package hu.miskolc.uni.googlebookssearchapplication.framework.network

import android.util.Log
import hu.miskolc.uni.core.data.BookDataSource
import hu.miskolc.uni.core.domain.Book

class NetworkDataSource(private val service: BooksService) : BookDataSource {

    override suspend fun fetchBooks(query: String): List<Book> {
        val response = service.fetchBooks(query)
        return if (response.isSuccessful) {
            response.body()?.items?.map {
                val book = it.volumeInfo.mapToBook()
                Log.d("Response Book", book.imageLinks.toString())

                book
            } ?: emptyList()
        } else {
            emptyList()
        }
    }

    override suspend fun saveBooks(books: List<Book>) {
        TODO("Not yet implemented")
    }
}