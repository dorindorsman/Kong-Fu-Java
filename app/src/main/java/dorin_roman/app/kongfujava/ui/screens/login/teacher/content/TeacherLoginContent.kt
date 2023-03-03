package dorin_roman.app.kongfujava.ui.screens.login.teacher.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dorin_roman.app.kongfujava.R
import dorin_roman.app.kongfujava.ui.theme.purpleColor1
import dorin_roman.app.kongfujava.ui.theme.redColor1
import dorin_roman.app.kongfujava.ui.theme.secondaryTextColor
import dorin_roman.app.kongfujava.ui.theme.spacing


@Composable
fun TeacherLoginScreenContent(
    navigateToMainScreen: () -> Unit,
    navigateToTeacherRegisterScreen: () -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(MaterialTheme.spacing.large)
            .fillMaxWidth()
    ) {
        Spacer(
            modifier = Modifier
                .weight(0.05f)
                .fillMaxHeight()
        )

//        Box(modifier = Modifier.weight(0.2f)) {
//            TeacherLoginScreenContentImage()
//        }

        Column(
            modifier = Modifier
                .weight(0.35f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TeacherLoginScreenContentImage()

            TeacherLoginScreenContentTexts()
        }

        Spacer(
            modifier = Modifier
                .weight(0.05f)
                .fillMaxHeight()
        )

        Column(
            modifier = Modifier
                .weight(0.35f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TeacherLoginScreenContentTextButton(
                navigateToMainScreen = navigateToMainScreen,
                navigateToTeacherRegisterScreen = navigateToTeacherRegisterScreen
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
fun TeacherLoginScreenContentImage() {
    Image(
        modifier = Modifier
            .size(150.dp,150.dp),
        painter = painterResource(id = R.drawable.ic_logo),
        contentDescription = stringResource(id = R.string.app_logo)
    )
}

@Composable
fun TeacherLoginScreenContentTexts() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small),
        textAlign = TextAlign.Center,
        text = stringResource(id = R.string.login_description),
        style = MaterialTheme.typography.body1
    )
}

@Composable
fun TeacherLoginScreenContentTextButton(
    navigateToMainScreen: () -> Unit,
    navigateToTeacherRegisterScreen: () -> Unit,
) {

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small),
        textAlign = TextAlign.Center,
        text = stringResource(id = R.string.login).uppercase(),
        style = MaterialTheme.typography.h4
    )

    var email by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = email,
        //leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
        trailingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
        onValueChange = {
            email = it
        },
        label = { Text(text = stringResource(id = R.string.register_email)) },
        placeholder = { Text(text = stringResource(id = R.string.register_enter_email)) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = purpleColor1,
            focusedLabelColor = purpleColor1,
            errorLabelColor = redColor1,
            errorBorderColor = redColor1,
            focusedBorderColor = purpleColor1,
            unfocusedBorderColor = purpleColor1
        )
    )

    var password by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = password,
        //leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
        trailingIcon = { Icon(imageVector = Icons.Default.Visibility, contentDescription = null) },
        onValueChange = {
            password = it
        },
        label = { Text(text = stringResource(id = R.string.register_password)) },
        placeholder = { Text(text = stringResource(id = R.string.register_enter_password)) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = purpleColor1,
            focusedLabelColor = purpleColor1,
            errorLabelColor = redColor1,
            errorBorderColor = redColor1,
            focusedBorderColor = purpleColor1,
            unfocusedBorderColor = purpleColor1
        )
    )

    Button(
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .padding(top = MaterialTheme.spacing.medium),
        colors = ButtonDefaults.buttonColors(backgroundColor = purpleColor1, contentColor = secondaryTextColor),
        onClick = {
            navigateToMainScreen()
        }
    ) {
        Text(text = stringResource(id = R.string.login).uppercase())
    }

    Button(
        modifier = Modifier
            .fillMaxWidth(0.6f),
        colors = ButtonDefaults.buttonColors(backgroundColor = purpleColor1, contentColor = secondaryTextColor),
        onClick = {
            navigateToTeacherRegisterScreen()
        }
    ) {
        Text(text =stringResource(id = R.string.login_create_account).uppercase())
    }

}