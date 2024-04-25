package tomljanovic.matko.quizatko.presentation.quizatko

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import tomljanovic.matko.quizatko.domain.repository.QuizatkoRepository
import tomljanovic.matko.quizatko.util.Resource
import javax.inject.Inject

@HiltViewModel
class QuizatkoViewModel @Inject constructor(
    private val repo: QuizatkoRepository
) : ViewModel() {
    var state by mutableStateOf(QuizatkoState())

    fun getQuestions(
        numberOfQuestions: Int,
        fetchFromRemote: Boolean = true
    ) = viewModelScope.launch {
        repo.getQuestions(
            numberOfQuestions = numberOfQuestions,
            fetchFromRemote = fetchFromRemote
        ).collect { result ->
            when (result) {
                is Resource.Error -> {
                    result.message?.let {
                        state = state.copy(
                            error = it
                        )
                    }
                }
                is Resource.Loading -> state = state.copy(
                    isLoading = result.isLoading
                )
                is Resource.Success -> result.data?.let {
                    state = state.copy(
                        questions = it
                    )
                }
            }
        }
    }
}
