package dorin_roman.app.kongfujava.ui.screens.login.main

import androidx.compose.runtime.Composable
import dorin_roman.app.kongfujava.ui.components.DevicePreviews
import dorin_roman.app.kongfujava.R
import dorin_roman.app.kongfujava.ui.components.SideScreenImage
import dorin_roman.app.kongfujava.ui.components.VerticalFortySixtyLayout
import dorin_roman.app.kongfujava.ui.screens.login.main.content.UserTypeScreenContent
import dorin_roman.app.kongfujava.ui.theme.KongFuJavaTheme
import dorin_roman.app.kongfujava.util.UserType

@Composable
fun UserTypeScreen(
    navigateToLoginScreen: (UserType) -> Unit
) {
    VerticalFortySixtyLayout(
        fortyLayout = {
            UserTypeScreenContent(
                navigateToLoginScreen = navigateToLoginScreen
            )
        },
        sixtyLayout = {
            SideScreenImage(R.drawable.ic_panda_usertype)
        }
    )
}

@DevicePreviews
@Composable
fun UserTypeScreenPreview() {
    KongFuJavaTheme {
        UserTypeScreen { }
    }
}