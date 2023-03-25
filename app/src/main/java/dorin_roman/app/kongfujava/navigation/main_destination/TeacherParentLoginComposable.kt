package dorin_roman.app.kongfujava.navigation.main_destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import dorin_roman.app.kongfujava.navigation.MAIN_ENTER_NAVIGATION_ANIMATION_TIME_MILLIS
import dorin_roman.app.kongfujava.navigation.screens.GeneralScreens.Companion.TEACHER_PARENT_LOGIN_SCREEN
import dorin_roman.app.kongfujava.navigation.screens.GeneralScreens.Companion.USER_TYPE_SCREEN
import dorin_roman.app.kongfujava.ui.screens.login.teacher_parent.TeacherParentLoginScreen
import dorin_roman.app.kongfujava.view_models.MainViewModel

@ExperimentalAnimationApi
fun NavGraphBuilder.teacherParentLoginComposable(
    navigateToMainScreen: () -> Unit,
    navigateToTeacherRegisterScreen: () -> Unit,
    navigateToParentRegisterScreen: () -> Unit,
    mainViewModel: MainViewModel
) {
    composable(
        route = TEACHER_PARENT_LOGIN_SCREEN,
        enterTransition = {
            slideInHorizontally(
                animationSpec = tween(
                    durationMillis = MAIN_ENTER_NAVIGATION_ANIMATION_TIME_MILLIS
                ),
                initialOffsetX = { fullWidth -> -fullWidth }
            )
        },
        arguments = listOf(
            navArgument(USER_TYPE_SCREEN){
                type = NavType.IntType
            }
        )
    ) {navBackStackEntry ->
        val userType = navBackStackEntry.arguments?.getInt(USER_TYPE_SCREEN) ?: 0

        TeacherParentLoginScreen(
            navigateToMainScreen = navigateToMainScreen,
            navigateToTeacherRegisterScreen = navigateToTeacherRegisterScreen,
            navigateToParentRegisterScreen = navigateToParentRegisterScreen,
            mainViewModel = mainViewModel,
            userType = userType
        )
    }
}