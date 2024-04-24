package tomljanovic.matko.quizatko.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tomljanovic.matko.quizatko.data.local.QuizatkoDatabase
import tomljanovic.matko.quizatko.data.remote.QuizatkoApi
import tomljanovic.matko.quizatko.domain.model.Question
import tomljanovic.matko.quizatko.domain.repository.QuizatkoRepository
import tomljanovic.matko.quizatko.util.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuizatkoRepositoryImpl @Inject constructor(
    private val quizatkoApi: QuizatkoApi,
    db: QuizatkoDatabase
) : QuizatkoRepository {
    private val dao = db.questionDao

    override fun getQuestions(
        numberOfQuestions: Int,
        fetchFromRemote: Boolean
    ): Flow<Resource<List<Question>>> {
        return flow {

        }
    }

}
