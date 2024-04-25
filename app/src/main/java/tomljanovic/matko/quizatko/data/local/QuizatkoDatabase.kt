package tomljanovic.matko.quizatko.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import tomljanovic.matko.quizatko.data.local.leaderboard.LeaderboardDao
import tomljanovic.matko.quizatko.data.local.leaderboard.LeaderboardEntity

@Database(
    entities = [QuestionEntity::class, LeaderboardEntity::class],
    version = 1
)
abstract class QuizatkoDatabase : RoomDatabase() {
    abstract val questionDao: QuestionDao
    abstract val leaderboardDao: LeaderboardDao
}
