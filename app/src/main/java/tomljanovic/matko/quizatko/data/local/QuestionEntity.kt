package tomljanovic.matko.quizatko.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import tomljanovic.matko.quizatko.util.Converters

@Entity
@TypeConverters(Converters::class)
data class QuestionEntity(
    val question: String,
    val correctAnswer: String,
    val answers: List<String>,

    @PrimaryKey
    val id: Int? = null
)
