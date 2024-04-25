package tomljanovic.matko.quizatko.data.local.leaderboard

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LeaderboardEntity(
    val name: String,
    val score: Int,

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)
