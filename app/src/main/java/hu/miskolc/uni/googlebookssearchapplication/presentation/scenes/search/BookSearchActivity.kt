package hu.miskolc.uni.googlebookssearchapplication.presentation.scenes.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.miskolc.uni.googlebookssearchapplication.R
import hu.miskolc.uni.googlebookssearchapplication.koin.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BookSearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_search_activity)

        startKoin{
            androidLogger()
            androidContext(this@BookSearchActivity)
            modules(databaseModule)
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, BookSearchFragment.newInstance())
                .commitNow()
        }
    }
}