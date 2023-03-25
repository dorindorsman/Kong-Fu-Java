package dorin_roman.app.kongfujava.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dorin_roman.app.kongfujava.R


@Composable
fun Title(@StringRes id: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = id).uppercase(),
            style = MaterialTheme.typography.h4.copy(color = MaterialTheme.colors.onBackground)
        )
        Image(
            modifier = Modifier
                .padding(5.dp)
                .size(80.dp, 80.dp),
            painter = painterResource(id = R.drawable.ic_panda_ninja),
            contentDescription = stringResource(id = R.string.app_logo)
        )
    }
}