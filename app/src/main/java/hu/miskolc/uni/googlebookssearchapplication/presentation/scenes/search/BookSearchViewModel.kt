package hu.miskolc.uni.googlebookssearchapplication.presentation.scenes.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hu.miskolc.uni.core.usecases.SearchBook
import hu.miskolc.uni.googlebookssearchapplication.presentation.scenes.displayModel.DisplayedBookModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BookSearchViewModel(private val searchBook: SearchBook) : ViewModel() {
    val books: MutableLiveData<List<DisplayedBookModel>> by lazy { MutableLiveData<List<DisplayedBookModel>>() }

    fun getBooks(query: String) {
        GlobalScope.launch {
            val result = searchBook(query)
            books.value = result.map {
                DisplayedBookModel(
                    it.imageLinks?.smallThumbnail,
                    it.title ?: "",
                    it.authors ?: emptyList()
                )
            }
        }
    }
}