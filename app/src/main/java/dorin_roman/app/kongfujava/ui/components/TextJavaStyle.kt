package dorin_roman.app.kongfujava.ui.components

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import dorin_roman.app.kongfujava.ui.theme.spacing
import dorin_roman.app.kongfujava.ui.theme.textBlue
import dorin_roman.app.kongfujava.ui.theme.textGray
import dorin_roman.app.kongfujava.ui.theme.textOrange
import dorin_roman.app.kongfujava.ui.theme.textPurple
import dorin_roman.app.kongfujava.ui.theme.textYellow

const val exampleString =
    """For Example, in the code snippet below:*
        We have declared a variable number.*
        Then we initialized the value of the variable.*
        Finally, we modified the value of the variable.**
        We will learn about this code snippet multiple times,
         so don't worry if you don't understand everything.**
        public! class! VariableDemo {*
        @public! static! void! main#(String[] args) {**
        @@// Variable declaration%*
        @@int! number;**
        @@// Assign a value to the variable%*
        @@number^ =~ 10&;**" +
        @@// Modified a variable value%*
        @@number^ =~ number^ +~ 20&;**
        @}**
        }*"""

@Composable
fun TextJavaStyle(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current
) {
    BoxWithConstraints(
        modifier = modifier
    ) {
        val scrollState = rememberScrollState()
        val viewMaxHeight = maxHeight.value
        val columnMaxScroll = scrollState.maxValue
        val scrollStateValue = scrollState.value
        val paddingSize = (scrollStateValue * viewMaxHeight) / columnMaxScroll
        val animation = animateDpAsState(paddingSize.dp)
        val scrollBarHeight = viewMaxHeight / 10

        if (scrollStateValue < columnMaxScroll) {
            Box(
                modifier = Modifier
                    .paddingFromBaseline(animation.value)
                    .padding(MaterialTheme.spacing.extraSmall)
                    .height(scrollBarHeight.dp)
                    .width(4.dp)
                    .background(
                        color = MaterialTheme.colors.onBackground,
                        shape = MaterialTheme.shapes.medium
                    )
                    .align(Alignment.TopEnd),
            )
        }

        Column(
            modifier = Modifier
                .verticalScroll(state = scrollState)
                .fillMaxWidth(),
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = MaterialTheme.spacing.extraLarge),
                textAlign = TextAlign.Start,
                style = style,
                text = buildAnnotatedString {
                    val newLine = "*"
                    val tab = "@"
                    val orange = "!"
                    val yellow = "#"
                    val purple = "^"
                    val blue = "&"
                    val comment = "%"
                    val white = "~"
                    text.split(Regex("(?<=[*@!#%^&~])")).forEach { string ->
                        Log.d("roman", string)
                        if (string.contains(newLine)) {
                            appendLine(string.dropLast(1))
                        } else if (string.contains(tab)) {
                            append("   ")
                        } else if (string.contains(orange)) {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colors.textOrange
                                )
                            ) {
                                append(string.dropLast(1))
                            }
                        } else if (string.contains(yellow)) {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colors.textYellow
                                )
                            ) {
                                append(string.dropLast(1))
                            }
                        } else if (string.contains(purple)) {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colors.textPurple
                                )
                            ) {
                                append(string.dropLast(1))
                            }
                        } else if (string.contains(blue)) {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colors.textBlue
                                )
                            ) {
                                append(string.dropLast(1))
                            }
                        } else if (string.contains(comment)) {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colors.textGray
                                )
                            ) {
                                append(string.dropLast(1))
                            }
                        } else if (string.contains(white)) {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colors.onBackground
                                )
                            ) {
                                append(string.dropLast(1))
                            }
                        } else {
                            append(string)
                        }
                    }
                }
            )
        }
    }
}