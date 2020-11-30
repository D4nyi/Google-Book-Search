package hu.miskolc.uni.googlebookssearchapplication.koin

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import hu.miskolc.uni.core.data.BookDataSource
import hu.miskolc.uni.googlebookssearchapplication.framework.network.BooksService
import hu.miskolc.uni.googlebookssearchapplication.framework.network.NetworkDataSource
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val databaseModule = module {
    /*
    single<BooksService> {
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder().baseUrl("https://www.googleapis.com")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson)).build()

        retrofit.create(BooksService::class.java)
    }

    single<BookDataSource> { NetworkDataSource(get()) }
    */
}