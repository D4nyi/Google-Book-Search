package hu.miskolc.uni.googlebookssearchapplication.framework.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksService {
    @GET("/books/v1/volumes")
    suspend fun fetchBooks(@Query("q") query: String ) : Response<BookServiceResponse>
}