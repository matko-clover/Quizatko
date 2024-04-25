package tomljanovic.matko.quizatko.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import tomljanovic.matko.quizatko.data.local.QuizatkoDatabase
import tomljanovic.matko.quizatko.data.mappers.toQuestion
import tomljanovic.matko.quizatko.data.mappers.toQuestionEntity
import tomljanovic.matko.quizatko.data.remote.QuizatkoApi
import tomljanovic.matko.quizatko.domain.model.Question
import tomljanovic.matko.quizatko.domain.repository.QuizatkoRepository
import tomljanovic.matko.quizatko.util.Resource
import java.io.IOException
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
            emit(value = Resource.Loading(isLoading = true))

            val remoteData = try {
                quizatkoApi.fetchQuestions(numberOfQuestions = numberOfQuestions).results
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Couldn't load data"))
                null
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Couldn't load data"))
                null
            }

            remoteData?.let { questions ->
                dao.clearQuestions()
                dao.insertQuestions(questions.map { it.toQuestionEntity() })
                emit(Resource.Success(data = dao.getLocalQuestions().map { it.toQuestion() }))
            }
            emit(Resource.Loading(isLoading = false))
        }
    }

}
