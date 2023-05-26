package dorin_roman.app.kongfujava.screens.level.drag_drop

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dorin_roman.app.kongfujava.data.models.RequestState
import dorin_roman.app.kongfujava.data.repository.LevelRepository
import dorin_roman.app.kongfujava.domain.models.levels.Answer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DragDropViewModel @Inject constructor(
    private val levelRepository: LevelRepository,
) : ViewModel() {

    companion object {
        const val TAG = "DragDropViewModel"
    }

    var isCurrentlyDragging by mutableStateOf(false)
        private set

    var drag by mutableStateOf(emptyList<String>())
        private set

    var drop by mutableStateOf(emptyList<String>())
        private set

    var questionLeft by mutableStateOf("")
        private set

    var questionRight by mutableStateOf("")
        private set

    var isRight by mutableStateOf(false)
        private set

    var shownHints by mutableStateOf(emptyList<String>())
        private set

    private var currentLevel: Int = -1

    private val answer = MutableStateFlow<RequestState<Answer>>(RequestState.Idle)

    fun handle(event: DragDropEvent) {
        when (event) {
            is DragDropEvent.InitAnswers -> initAnswers(event.levelId)
            is DragDropEvent.UpdateQuestion -> updateQuestion(event.question)
            is DragDropEvent.CheckAnswer -> {} // TODO
            DragDropEvent.GetHint -> {} // TODO
        }
    }

    private fun initAnswers(levelId: Int) {
        currentLevel = levelId
        loadAnswer()
    }

    private fun updateQuestion(question: String) {
        val array = question.split("<")
        if (array.size == 2) {
            questionLeft = array.first()
            questionRight = array.last()
        }
    }

    private fun loadAnswer() {
        Log.d(TAG, "loadAnswer")
        answer.value = RequestState.Loading
        try {
            viewModelScope.launch {
                levelRepository.getAnswer(currentLevel).collect { answer ->
                    this@DragDropViewModel.answer.value = RequestState.Success(answer)
                    buildDrag(answer)
                    buildDrop()
                }
            }
        } catch (e: Exception) {
            answer.value = RequestState.Error(e)
        }
    }

    private fun buildDrop() {
        drop = listOf(
            "1",
            "2",
            "3",
            "4"
        )
    }

    private fun buildDrag(answer: Answer) {
        drag = listOf(
            answer.answer1,
            answer.answer2,
            answer.answer3,
            answer.answer4,
        )
    }

    fun startDragging() {
        isCurrentlyDragging = true
    }

    fun stopDragging() {
        isCurrentlyDragging = false
    }

    fun checkAnswer(answer: String?) {
        Log.d(TAG, "checkAnswer")
    }
}