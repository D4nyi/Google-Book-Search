package hu.miskolc.uni.googlebookssearchapplication.framework.db.model

import androidx.room.*

@Entity(tableName = "Book")
data class BookRecord(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val title: String?,
    val publisher: String?,
    val publishedDate: String?,
    val description: String?,
    val pageCount: Int?,
    val averageRating: Float?,
    val ratingsCount: Int?,
    @Embedded val imageLinks: ImageLinksRecord?,
    val language: String?,
    val previewLink: String?,
    val infoLink: String?,
    val canonicalVolumeLink: String?
)

@Entity(
    tableName = "Author", foreignKeys = [
        ForeignKey(
            entity = BookRecord::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("bookId"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class AuthorRecord(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val name: String,
    val bookId: Long?
)

data class ImageLinksRecord(
    val smallThumbnail: String?,
    val thumbnail: String?,
)

data class BookRecordInfo(
    @Embedded var book: BookRecord,
    @Relation(
        parentColumn = "id",
        entityColumn = "bookId",
        entity = AuthorRecord::class
    )
    var authors: List<AuthorRecord>
)
