package tomljanovic.matko.quizatko.presentation.leaderboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import tomljanovic.matko.quizatko.domain.repository.LeaderboardRepository
import tomljanovic.matko.quizatko.util.Resource
import javax.inject.Inject

@HiltViewModel
class LeaderboardViewModel @Inject constructor(
    private val repo: LeaderboardRepository
) : ViewModel() {
    var state by mutableStateOf(LeaderboardState())

    init {
        getLeaderboard()
    }

    fun getLeaderboard() = viewModelScope.launch {
        repo.getLeaderboard().collect { result ->
            when (result) {
                is Resource.Error -> {
                    // ignore
                }

                is Resource.Loading -> {
                    state = state.copy(
                        isLoading = result.isLoading
                    )
                }

                is Resource.Success -> {
                    result.data?.let {
                        state = state.copy(
                            items = it
                        )
                    }
                }
            }
        }
    }

    fun clearLeaderboard() = viewModelScope.launch {
        repo.clearLeaderboard()
    }
}
