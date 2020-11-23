package hu.miskolc.uni.core.data

import hu.miskolc.uni.core.domain.Book

interface BookDataSource {
    suspend fun fetchBooks(query: String): List<Book>

    suspend fun saveBooks(books: List<Book>)
}