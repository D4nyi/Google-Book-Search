package hu.miskolc.uni.googlebookssearchapplication.framework.network

import hu.miskolc.uni.core.data.BookDataSource
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.java.KoinJavaComponent.inject

class NetworkDataSourceTest {

    private val dataSource: BookDataSource by inject(NetworkDataSource::class.java)

    @Test
    fun fetchBooks() = runBlocking {
        val books = dataSource.fetchBooks("harry potter")

        /*val correctTitle = books.all{
            it.title?.contains("Harry Potter")?: false
        }*/

        Assert.assertNotNull(books)
        Assert.assertFalse(books.isEmpty())
        Assert.assertEquals(books.size, 10)
        //Assert.assertTrue(correctTitle)
    }

    @Test
    fun saveBooks() {
    }
}