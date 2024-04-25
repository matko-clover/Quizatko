package tomljanovic.matko.quizatko.data.mappers

import tomljanovic.matko.quizatko.data.local.QuestionEntity
import tomljanovic.matko.quizatko.data.remote.QuestionsResponse
import tomljanovic.matko.quizatko.data.remote.ResultsResponse
import tomljanovic.matko.quizatko.domain.model.Question

fun QuestionEntity.toQuestion() : Question {
    return Question(
        question = question,
        correctAnswer = correctAnswer,
        answers = answers
    )
}

fun ResultsResponse.toQuestionEntity() : QuestionEntity {
    val answers = incorrectAnswer.apply { add(correctAnswer) }.shuffled()
    return QuestionEntity(
        question = question,
        correctAnswer = correctAnswer,
        answers = answers
    )
}
