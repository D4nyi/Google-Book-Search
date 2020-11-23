package hu.miskolc.uni.core.data

import hu.miskolc.uni.core.domain.Book

class BookRepository(
    private val localDataSource: BookDataSource,
    private val remoteDataSource: BookDataSource
) {
    suspend fun fetchBooks(query: String): List<Book> {
        val localResults = localDataSource.fetchBooks(query)
        return if (localResults.isNotEmpty()) {
            localResults
        } else {
            val remoteResults = remoteDataSource.fetchBooks(query)
            if (remoteResults.isNotEmpty()) {
                localDataSource.saveBooks(remoteResults)
                remoteResults
            } else {
                emptyList()
            }
        }
    }
}