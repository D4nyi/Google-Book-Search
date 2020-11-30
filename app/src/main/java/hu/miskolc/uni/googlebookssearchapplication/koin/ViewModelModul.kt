package hu.miskolc.uni.googlebookssearchapplication.koin

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import hu.miskolc.uni.core.data.BookRepository
import hu.miskolc.uni.core.usecases.SearchBook
import hu.miskolc.uni.googlebookssearchapplication.framework.db.BookDatabase
import hu.miskolc.uni.googlebookssearchapplication.framework.db.datasource.RoomBookDataSource
import hu.miskolc.uni.googlebookssearchapplication.framework.network.BooksService
import hu.miskolc.uni.googlebookssearchapplication.framework.network.NetworkDataSource
import hu.miskolc.uni.googlebookssearchapplication.presentation.scenes.search.BookSearchViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {

    single {
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder().baseUrl("https://www.googleapis.com")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson)).build()

        val service = retrofit.create(BooksService::class.java)

        NetworkDataSource(service)
    }

    single {
        val db = BookDatabase.getInstance(androidContext()) as BookDatabase

        RoomBookDataSource(db.getBookRecordDao(), db.getAuthorRecordDao())
    }

    single { BookRepository(get<RoomBookDataSource>(), get<NetworkDataSource>()) }

    single { SearchBook(get()) }

    viewModel { BookSearchViewModel(get()) }
}