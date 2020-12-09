package hu.miskolc.uni.googlebookssearchapplication.presentation.scenes.search

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import hu.miskolc.uni.googlebookssearchapplication.R
import hu.miskolc.uni.googlebookssearchapplication.koin.databaseModule
import hu.miskolc.uni.googlebookssearchapplication.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BookSearchActivity : AppCompatActivity() {

    private var searchTerm: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_search_activity)

        startKoin {
            androidLogger()
            androidContext(this@BookSearchActivity)
            modules(listOf(databaseModule, viewModelModule))
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, BookSearchFragment.newInstance())
                .commitNow()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.book_search_menu, menu)

        if (menu == null) {
            return false
        }

        val menuItem = menu.findItem(R.id.bookSearch)
        val searchView: SearchView = menuItem.actionView as SearchView
        searchView.queryHint = "Type here to Search"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    searchTerm = query
                    Log.d("Search", query)
                    return true
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        return true
    }
}
