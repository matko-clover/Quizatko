package tomljanovic.matko.quizatko.data.local.leaderboard

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LeaderboardDao {
    @Query("SELECT * FROM leaderboardentity")
    suspend fun getLeaderboard(): List<LeaderboardEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLeaderboardItem(leaderboardEntity: LeaderboardEntity)

    @Query("DELETE FROM leaderboardentity")
    suspend fun clearLeaderboard()
}
