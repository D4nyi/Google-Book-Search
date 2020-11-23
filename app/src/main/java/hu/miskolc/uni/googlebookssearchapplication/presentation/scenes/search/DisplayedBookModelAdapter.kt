package hu.miskolc.uni.googlebookssearchapplication.presentation.scenes.search

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hu.miskolc.uni.googlebookssearchapplication.R
import hu.miskolc.uni.googlebookssearchapplication.presentation.scenes.displayModel.DisplayedBookModel
import kotlinx.android.synthetic.main.book_search_list_item.view.*

class DisplayedBookModelAdapter : RecyclerView.Adapter<DisplayedBookModelAdapter.ViewHolder>() {
    private val books = ArrayList<DisplayedBookModel>()

    fun setBooks(books: List<DisplayedBookModel>){
        this.books.clear()
        this.books.addAll(books)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_search_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = books.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var view: View = itemView
        private var book: DisplayedBookModel? = null

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            Log.d("RecyclerView", "Click!!!")
        }

        fun bind(position: Int) {
            val item = books[position]
            with(view) {
                Glide.with(this).load(item.thumbnailUrl).into(itemImage)
                itemTitle?.text = item.title
                itemAuthors?.text = item.authors.joinToString(" ,")
            }
        }
    }
}