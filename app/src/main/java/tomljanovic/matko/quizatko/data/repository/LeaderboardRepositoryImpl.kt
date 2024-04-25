package tomljanovic.matko.quizatko.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tomljanovic.matko.quizatko.data.local.QuizatkoDatabase
import tomljanovic.matko.quizatko.data.mappers.toLeaderboardEntity
import tomljanovic.matko.quizatko.data.mappers.toLeaderboardItem
import tomljanovic.matko.quizatko.domain.model.LeaderboardItem
import tomljanovic.matko.quizatko.domain.repository.LeaderboardRepository
import tomljanovic.matko.quizatko.util.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LeaderboardRepositoryImpl @Inject constructor(
    db: QuizatkoDatabase
) : LeaderboardRepository {
    private val dao = db.leaderboardDao

    override fun getLeaderboard(): Flow<Resource<List<LeaderboardItem>>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val localLeaderboard = dao.getLeaderboard()

            emit(Resource.Success(data = localLeaderboard.map { it.toLeaderboardItem() }))
            emit(Resource.Loading(isLoading = false))
        }
    }

    override suspend fun addToLeaderboard(leaderboardItem: LeaderboardItem) {
        dao.insertLeaderboardItem(leaderboardEntity = leaderboardItem.toLeaderboardEntity())
    }

    override suspend fun clearLeaderboard() {
        dao.clearLeaderboard()
    }
}
