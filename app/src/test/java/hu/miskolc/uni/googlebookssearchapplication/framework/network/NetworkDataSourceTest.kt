package hu.miskolc.uni.googlebookssearchapplication.framework.network

import hu.miskolc.uni.core.data.BookDataSource
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class NetworkDataSourceTest {

    private lateinit var dataSource: BookDataSource

    @Before
    fun setUp() {
        dataSource = NetworkDataSource()
    }

    @After
    fun tearDown() {
    }

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