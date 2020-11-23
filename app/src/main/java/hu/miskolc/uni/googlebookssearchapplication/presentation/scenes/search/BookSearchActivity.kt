package hu.miskolc.uni.googlebookssearchapplication.presentation.scenes.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.miskolc.uni.googlebookssearchapplication.R

class BookSearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_search_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, BookSearchFragment.newInstance())
                .commitNow()
        }
    }
}