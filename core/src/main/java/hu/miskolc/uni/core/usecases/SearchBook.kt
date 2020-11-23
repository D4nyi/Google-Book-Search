package hu.miskolc.uni.core.usecases

import hu.miskolc.uni.core.data.BookRepository

class SearchBook(private val repository: BookRepository) {
    suspend operator fun invoke(query: String) = repository.fetchBooks(query)
}