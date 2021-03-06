package hu.miskolc.uni.googlebookssearchapplication.presentation.scenes.search

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import hu.miskolc.uni.googlebookssearchapplication.R
import kotlinx.android.synthetic.main.book_search_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class BookSearchFragment : Fragment() {

    private val viewModel: BookSearchViewModel by sharedViewModel()
    private lateinit var adapter: DisplayedBookModelAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(BookSearchViewModel::class.java)
        adapter = DisplayedBookModelAdapter()

        bookList.layoutManager = LinearLayoutManager(context)
        bookList.adapter = adapter
        viewModel.books.observe(viewLifecycleOwner, Observer {
            adapter.setBooks(it)
            adapter.notifyDataSetChanged()
        })

        viewModel.getBooks("Harry Potter")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.book_search_fragment, container, false)
    }

    companion object {
        fun newInstance() = BookSearchFragment()
    }
}