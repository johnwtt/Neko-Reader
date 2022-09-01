package eu.kanade.tachiyomi.ui.more.stats

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.nekomanga.domain.manga.MangaStatus
import org.nekomanga.domain.manga.MangaType

object StatsConstants {
    data class SimpleState(
        val screenState: ScreenState = ScreenState.Loading,
        val mangaCount: Int = 0,
        val chapterCount: Int = 0,
        val readCount: Int = 0,
        val trackedCount: Int = 0,
        val globalUpdateCount: Int = 0,
        val downloadCount: Int = 0,
        val tagCount: Int = 0,
        val mergeCount: Int = 0,
        val averageMangaRating: Double = 0.0,
        val averageUserRating: Double = 0.0,
        val trackerCount: Int = 0,
        val readDuration: String = "",
        val lastLibraryUpdate: String = "",
        val statusDistribution: ImmutableList<StatusDistribution> = persistentListOf(),
    )

    data class DetailedState(
        val isLoading: Boolean = true,
        val manga: ImmutableList<DetailedStatManga> = persistentListOf(),
    )

    data class DetailedStatManga(
        val id: Long,
        val title: String,
        val status: MangaStatus,
        val type: MangaType,
        val totalChapters: Int,
        val readChapters: Int,
        val readDuration: String,
        val rating: Double?,
        val userScore: Double?,
        val startYear: Int?,
        val trackers: ImmutableList<String>,
        val tags: ImmutableList<String>,
        val categories: ImmutableList<String>,
    )

    sealed class ScreenState {
        object Loading : ScreenState()
        object Simple : ScreenState()
        object Detailed : ScreenState()
        object NoResults : ScreenState()
    }

    data class StatusDistribution(val status: MangaStatus, val distribution: Int)
}
