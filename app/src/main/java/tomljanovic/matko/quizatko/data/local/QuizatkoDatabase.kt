package tomljanovic.matko.quizatko.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [QuestionEntity::class],
    version = 1
)
abstract class QuizatkoDatabase : RoomDatabase() {
    abstract val questionDao: QuestionDao
}
