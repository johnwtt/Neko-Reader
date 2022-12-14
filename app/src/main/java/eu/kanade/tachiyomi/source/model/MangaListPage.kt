package eu.kanade.tachiyomi.source.model

import eu.kanade.tachiyomi.data.models.SourceManga

data class MangaListPage(
    val manga: List<SManga> = emptyList(),
    val hasNextPage: Boolean,
    val displayManga: List<SourceManga> = emptyList(),
)
