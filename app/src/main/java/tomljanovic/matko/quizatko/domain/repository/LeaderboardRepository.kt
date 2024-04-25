package tomljanovic.matko.quizatko.domain.repository

import kotlinx.coroutines.flow.Flow
import tomljanovic.matko.quizatko.domain.model.LeaderboardItem
import tomljanovic.matko.quizatko.util.Resource

interface LeaderboardRepository {
    fun getLeaderboard(): Flow<Resource<List<LeaderboardItem>>>
    suspend fun addToLeaderboard(leaderboardItem: LeaderboardItem)
    suspend fun clearLeaderboard()
}
