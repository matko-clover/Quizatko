package tomljanovic.matko.quizatko.data.remote

import com.google.gson.annotations.SerializedName

data class QuestionsResponse(
    val results: List<ResultsResponse>
)

data class ResultsResponse(
    val question: String,

    @SerializedName(value = "correct_answer")
    val correctAnswer: String,

    @SerializedName(value = "incorrect_answer")
    val incorrectAnswer: MutableList<String>
)
