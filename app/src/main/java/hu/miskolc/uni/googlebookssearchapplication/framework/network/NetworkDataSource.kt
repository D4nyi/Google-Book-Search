package hu.miskolc.uni.googlebookssearchapplication.framework.network

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import hu.miskolc.uni.core.data.BookDataSource
import hu.miskolc.uni.core.domain.Book
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkDataSource : BookDataSource {
    private val retrofit: Retrofit
    private val service: BooksService

    init {
        val gson = GsonBuilder().create()
        retrofit = Retrofit.Builder().baseUrl("https://www.googleapis.com")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson)).build()

        service = retrofit.create(BooksService::class.java)
    }

    override suspend fun fetchBooks(query: String): List<Book> {
        val response = service.fetchBooks(query)
        return if (response.isSuccessful) {
            response.body()?.items?.map {
                it.volumeInfo.mapToBook()
            } ?: emptyList()
        } else {
            emptyList()
        }
    }

    override suspend fun saveBooks(books: List<Book>) {
        TODO("Not yet implemented")
    }
}