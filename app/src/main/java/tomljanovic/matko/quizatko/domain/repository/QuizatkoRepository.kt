package tomljanovic.matko.quizatko.domain.repository

import kotlinx.coroutines.flow.Flow
import tomljanovic.matko.quizatko.domain.model.Question
import tomljanovic.matko.quizatko.util.Resource

interface QuizatkoRepository {
    fun getQuestions(
        numberOfQuestions: Int,
        fetchFromRemote: Boolean
    ): Flow<Resource<List<Question>>>
}
