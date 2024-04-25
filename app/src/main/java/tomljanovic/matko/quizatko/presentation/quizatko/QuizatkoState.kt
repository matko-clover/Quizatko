package tomljanovic.matko.quizatko.presentation.quizatko

import tomljanovic.matko.quizatko.domain.model.Question

data class QuizatkoState(
    val questions: List<Question> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)
