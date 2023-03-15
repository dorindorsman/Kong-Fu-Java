package dorin_roman.app.kongfujava.ui.screens.register.parent.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocalLibrary
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import dorin_roman.app.kongfujava.R
import dorin_roman.app.kongfujava.ui.theme.spacing

@Composable
fun RegisterParentScreenContent(navigateToTeacherParentLoginScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(MaterialTheme.spacing.large)
            .fillMaxHeight()
    ) {
        Spacer(
            modifier = Modifier
                .weight(0.05f)
                .fillMaxWidth()
        )

        Box(modifier = Modifier.weight(0.2f)) {
            RegisterParentScreenContentImage()
        }

        Column(
            modifier = Modifier
                .weight(0.35f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RegisterParentScreenContentTexts()
        }

        Column(
            modifier = Modifier
                .weight(0.8f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RegisterParentScreenContentTextFields(
                navigateToTeacherParentLoginScreen = navigateToTeacherParentLoginScreen
            )
        }

        Spacer(
            modifier = Modifier
                .weight(0.05f)
                .fillMaxWidth()
        )
    }
}

@Composable
fun RegisterParentScreenContentImage() {
    Image(
        modifier = Modifier
            .fillMaxSize(),
        painter = painterResource(id = R.drawable.ic_logo),
        contentDescription = stringResource(id = R.string.app_logo)
    )
}

@Composable
fun RegisterParentScreenContentTexts() {

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small),
        textAlign = TextAlign.Center,
        text = stringResource(id = R.string.register_description),
        style = MaterialTheme.typography.body1
    )

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small),
        textAlign = TextAlign.Center,
        text = stringResource(id = R.string.register).uppercase(),
        style = MaterialTheme.typography.h4
    )

}

@Composable
fun RegisterParentScreenContentTextFields(
    navigateToTeacherParentLoginScreen: () -> Unit
) {

    ParentTextFieldWithIcons(
        label = R.string.register_email,
        placeholder = R.string.register_enter_email,
        icon = Icons.Default.Email)

    ParentTextFieldWithIcons(
        label = R.string.register_password,
        placeholder = R.string.register_enter_password,
        icon = Icons.Default.VisibilityOff
    )

    Button(
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .padding(MaterialTheme.spacing.medium),
        onClick = {
            navigateToTeacherParentLoginScreen()
        }
    ) {
        Text(text = stringResource(id = R.string.register).uppercase())
    }

}


@Composable
fun ParentTextFieldWithIcons(label: Int, placeholder: Int, icon: ImageVector) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        //leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
        trailingIcon = { Icon(imageVector = icon, contentDescription = null) },
        onValueChange = {
            text = it
        },
        label = { Text(text = stringResource(id = label)) },
        placeholder = { Text(text = stringResource(id = placeholder)) }
    )
}