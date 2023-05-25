package dorin_roman.app.kongfujava.screens.level.multi_choice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import dorin_roman.app.kongfujava.R
import dorin_roman.app.kongfujava.screens.level.LevelEvent
import dorin_roman.app.kongfujava.screens.level.LevelViewModel
import dorin_roman.app.kongfujava.screens.level.multi_choice.components.MultiChoiceScreenContent
import dorin_roman.app.kongfujava.ui.components.DevicePreviews
import dorin_roman.app.kongfujava.ui.components.VerticalFortySixtyLayout
import dorin_roman.app.kongfujava.ui.components.image.SideScreenImage
import dorin_roman.app.kongfujava.ui.components.topbar.TopBar
import dorin_roman.app.kongfujava.ui.theme.KongFuJavaTheme

@Composable
fun MultiChoiceScreen(
    levelViewModel: LevelViewModel = hiltViewModel(),
    multiChoiceViewModel: MultiChoiceViewModel = hiltViewModel(),
    navigateToMapLevelsScreenFromLevel: (worldId: Int) -> Unit,
    levelId: Int,
    levelNumber: Int,
    worldId: Int
) {

    LaunchedEffect(key1 = true) {
        levelViewModel.handle(LevelEvent.InitLevel(levelId, worldId))
        multiChoiceViewModel.handle(MultiEvent.InitAnswers(levelId))
    }


    Scaffold(
        topBar = {
            TopBar(
                onBackPressed = {
                    levelViewModel.handle(LevelEvent.HandleExit)
                },
                title = R.string.multi_choice_questions
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(MaterialTheme.colors.secondary)
                .padding(padding)
        ) {
            VerticalFortySixtyLayout(
                fortyLayout = {
                    MultiChoiceScreenContent(
                        navigateToMapLevelsScreenFromLevel = navigateToMapLevelsScreenFromLevel,
                        levelNumber = levelNumber,
                        title = levelViewModel.title,
                        questionTitle = levelViewModel.questionTitle,
                        questionAnswers = multiChoiceViewModel.answers,
                        worldId = worldId,
                        levelState = levelViewModel.state,
                        isFinish = levelViewModel.isFinish,
                        isExit = levelViewModel.isExit,
                        isRight = multiChoiceViewModel.isRight,
                        shownHints = multiChoiceViewModel.shownHints,
                        hintsCount = levelViewModel.hint,
                        finishLevel = { levelViewModel.handle(LevelEvent.FinishLevel) },
                        handleHint = {
                            multiChoiceViewModel.handle(MultiEvent.GetHint)
                            levelViewModel.handle(LevelEvent.UpdateLevelHint)
                        },
                        checkAnswer = { multiChoiceViewModel.handle(MultiEvent.CheckAnswer("")) },
                        handleExit = { levelViewModel.handle(LevelEvent.HandleExit) })
                },
                sixtyLayout = {
                    SideScreenImage(R.drawable.ic_panda_question)
                }
            )
        }
    }
}


@DevicePreviews
@Composable
fun WorldsScreenPreview() {
    KongFuJavaTheme {
        MultiChoiceScreen(
            multiChoiceViewModel = viewModel(),
            navigateToMapLevelsScreenFromLevel = { },
            levelId = 0,
            levelNumber = 0,
            worldId = 0,
        )
    }
}