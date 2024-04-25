package tomljanovic.matko.quizatko.data.mappers

import tomljanovic.matko.quizatko.data.local.leaderboard.LeaderboardEntity
import tomljanovic.matko.quizatko.domain.model.LeaderboardItem

fun LeaderboardEntity.toLeaderboardItem(): LeaderboardItem {
    return LeaderboardItem(
        name = name,
        score = score
    )
}

fun LeaderboardItem.toLeaderboardEntity(): LeaderboardEntity {
    return LeaderboardEntity(
        name = name,
        score = score
    )
}
