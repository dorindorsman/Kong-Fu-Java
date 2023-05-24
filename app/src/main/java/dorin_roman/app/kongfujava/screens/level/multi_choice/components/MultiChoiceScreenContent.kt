package dorin_roman.app.kongfujava.screens.level.multi_choice.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import dorin_roman.app.kongfujava.R
import dorin_roman.app.kongfujava.ui.components.DevicePreviews
import dorin_roman.app.kongfujava.ui.components.LevelButtons
import dorin_roman.app.kongfujava.ui.theme.KongFuJavaTheme
import dorin_roman.app.kongfujava.ui.theme.spacing

@Composable
fun MultiChoiceScreenContent(
    navigateToMapLevelsScreenFromLevel: (worldId: Int) -> Unit,
    levelNumber: Int,
    title: String,
    questionTitle: String,
    questionAnswers: List<String>,
    worldId: Int,
    shownHints: List<String>,
    finishLevel: () -> Unit,
    handleHint: () -> Unit,
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.extraLarge)
    ) {
        val (level, lesson, question, answers, buttons) = createRefs()

        Text(
            modifier = Modifier
                .constrainAs(level) {
                    start.linkTo(parent.start, 10.dp)
                    top.linkTo(parent.top, 10.dp)

                },
            text = "${stringResource(id = R.string.level).uppercase()} $levelNumber",
            style = MaterialTheme.typography.h5.copy(color = MaterialTheme.colors.onBackground)
        )

        Text(
            modifier = Modifier
                .constrainAs(lesson) {
                    start.linkTo(parent.start, 10.dp)
                    top.linkTo(level.bottom)
                },
            text = title,
            style = MaterialTheme.typography.h4.copy(color = MaterialTheme.colors.onBackground)
        )

        Text(
            modifier = Modifier
                .constrainAs(question) {
                    linkTo(start = parent.start, startMargin = 10.dp, end = parent.end, endMargin = 10.dp)
                    top.linkTo(lesson.bottom, 20.dp)
                }
                .padding(10.dp),
            text = questionTitle,
            style = MaterialTheme.typography.h5.copy(color = MaterialTheme.colors.onBackground)
        )

        if (questionAnswers.isNotEmpty()) {
            MultiChoiceAnswers(
                modifier = Modifier
                    .constrainAs(answers) {
                        linkTo(start = parent.start, startMargin = 10.dp, end = parent.end, endMargin = 10.dp)
                        top.linkTo(question.bottom, 20.dp)
                    }, questionAnswers, shownHints
            )
        }

        LevelButtons(modifier = Modifier
            .constrainAs(buttons) {
                bottom.linkTo(parent.bottom, 20.dp)
                end.linkTo(parent.end, 20.dp)
            }
            .padding(10.dp),
            onClickHint = {
                //fixme
                handleHint()
            },
            OnClickNext = {
                //fixme
                finishLevel()
                navigateToMapLevelsScreenFromLevel(worldId)
            })
    }
}


@DevicePreviews
@Composable
fun WorldsScreenPreview() {
    KongFuJavaTheme {
        MultiChoiceScreenContent(
            { },
            0,
            "title",
            "question title",
            emptyList(),
            0,
            emptyList(),
            {},
            {}
        )
    }
}
