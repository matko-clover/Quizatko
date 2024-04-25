package tomljanovic.matko.quizatko.presentation.leaderboard

import tomljanovic.matko.quizatko.domain.model.LeaderboardItem

data class LeaderboardState(
    val items: List<LeaderboardItem> = emptyList(),
    val isLoading: Boolean = false
)
