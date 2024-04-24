package tomljanovic.matko.quizatko.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface QuizatkoApi {

    @GET("api.php")
    suspend fun fetchQuestions(
        @Query("amount") numberOfQuestions: Int
    ): QuestionsResponse

    companion object {
        const val BASE_URL = "https://opentdb.com/"
    }
}
