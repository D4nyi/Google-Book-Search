package hu.miskolc.uni.core.domain

data class Book(
    val title: String?,
    val authors: List<String>?,
    val publisher: String?,
    val publishedDate: String?,
    val description: String?,
    val pageCount: Int?,
    val averageRating: Float?,
    val ratingsCount: Int?,
    val imageLinks: ImageLinks?,
    val language: String?,
    val previewLink: String?,
    val infoLink: String?,
    val canonicalVolumeLink: String?,
)

data class ImageLinks(
    val smallThumbnail: String?,
    val thumbnail: String?,
)