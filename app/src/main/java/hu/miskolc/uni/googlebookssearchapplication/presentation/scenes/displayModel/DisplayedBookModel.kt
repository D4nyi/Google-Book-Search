package hu.miskolc.uni.googlebookssearchapplication.presentation.scenes.displayModel

data class DisplayedBookModel(
    val thumbnailUrl: String?,
    val title: String,
    val authors: List<String>
)
