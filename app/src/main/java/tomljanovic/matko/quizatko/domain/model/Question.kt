package tomljanovic.matko.quizatko.domain.model

data class Question(
    val question: String,
    val correctAnswer: String,
    val answers: List<String>
)
