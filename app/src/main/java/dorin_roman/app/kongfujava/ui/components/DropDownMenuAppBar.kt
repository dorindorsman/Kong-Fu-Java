package dorin_roman.app.kongfujava.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dorin_roman.app.kongfujava.R

@Composable
fun DropDownMenuAppBar(showMenu: Boolean, onDismissRequest: () -> Unit) {

    DropdownMenu(
        expanded = showMenu,
        onDismissRequest =  onDismissRequest
    ) {

        DropdownMenuItem(onClick = { /*TODO*/ }) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = stringResource(id = R.string.settings),
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(40.dp)
                )
                Text(
                    text = stringResource(id = R.string.settings),
                    style = MaterialTheme.typography.h4.copy(color = MaterialTheme.colors.onBackground)
                )
            }
        }


        DropdownMenuItem(onClick = { /*TODO*/ }) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Default.MusicNote,
                    contentDescription = stringResource(id = R.string.music),
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(40.dp)
                )
                Text(
                    text = stringResource(id = R.string.music),
                    style = MaterialTheme.typography.h4.copy(color = MaterialTheme.colors.onBackground)
                )
            }
        }

        DropdownMenuItem(onClick = { /*TODO*/ }) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Default.Help,
                    contentDescription = stringResource(id = R.string.help),
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(40.dp)
                )
                Text(
                    text = stringResource(id = R.string.help),
                    style = MaterialTheme.typography.h4.copy(color = MaterialTheme.colors.onBackground)
                )
            }
        }

    }
}