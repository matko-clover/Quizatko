package tomljanovic.matko.quizatko.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tomljanovic.matko.quizatko.data.repository.QuizatkoRepositoryImpl
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
}
