package hu.miskolc.uni.googlebookssearchapplication.framework.network

import hu.miskolc.uni.core.domain.Book

data class BookServiceResponse(
    val totalItems: Int,
    val items: List<ItemInfo>,
)

data class ItemInfo(val volumeInfo: VolumeInfo)

data class VolumeInfo(
    val title: String?,
    val authors: List<String>?,
    val publisher: String?,
    val publishedDate: String?,
    val description: String?,
    val pageCount: Int?,
    val averageRating: Float?,
    val ratingsCount: Int?,
    val ImageLinks: ImageLinks?,
    val language: String?,
    val previewLink: String?,
    val infoLink: String?,
    val canonicalVolumeLink: String?,
) {
    fun mapToBook(): Book {
        return Book(
            title,
            authors,
            publisher,
            publishedDate,
            description,
            pageCount,
            averageRating,
            ratingsCount,
            ImageLinks?.mapToImageLinks(),
            language,
            previewLink,
            infoLink,
            canonicalVolumeLink
        )
    }
}

data class ImageLinks(
    val smallThumbnail: String?,
    val thumbnail: String?,
) {
    fun mapToImageLinks(): hu.miskolc.uni.core.domain.ImageLinks {
        return hu.miskolc.uni.core.domain.ImageLinks(smallThumbnail, thumbnail)
    }
}