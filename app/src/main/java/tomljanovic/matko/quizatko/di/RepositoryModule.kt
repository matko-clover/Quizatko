package tomljanovic.matko.quizatko.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tomljanovic.matko.quizatko.data.repository.LeaderboardRepositoryImpl
import tomljanovic.matko.quizatko.data.repository.QuizatkoRepositoryImpl
import tomljanovic.matko.quizatko.domain.repository.LeaderboardRepository
import tomljanovic.matko.quizatko.domain.repository.QuizatkoRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindQuizatkoRepository(
        quizatkoRepositoryImpl: QuizatkoRepositoryImpl
    ): QuizatkoRepository

    @Binds
    @Singleton
    abstract fun  bindLeaderboardRepository(
        leaderboardRepositoryImpl: LeaderboardRepositoryImpl
    ): LeaderboardRepository
}
