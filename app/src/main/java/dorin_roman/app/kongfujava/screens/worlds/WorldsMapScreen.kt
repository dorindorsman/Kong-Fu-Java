package dorin_roman.app.kongfujava.screens.worlds

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dorin_roman.app.kongfujava.R
import dorin_roman.app.kongfujava.data.models.RequestState
import dorin_roman.app.kongfujava.screens.top_bar.TopBarEvent
import dorin_roman.app.kongfujava.screens.top_bar.TopBarViewModel
import dorin_roman.app.kongfujava.screens.worlds.components.WorldsMapContent
import dorin_roman.app.kongfujava.ui.components.DevicePreviews
import dorin_roman.app.kongfujava.ui.components.topbar.TopBar
import dorin_roman.app.kongfujava.ui.theme.KongFuJavaTheme

@Composable
fun WorldsMapScreen(
    navigateToMapLevels: (id: Int) -> Unit,
    worldsMapViewModel: WorldsMapViewModel = hiltViewModel(),
    topBarViewModel: TopBarViewModel = hiltViewModel()
) {
    val worlds = worldsMapViewModel.worlds.collectAsState().value

    Scaffold(
        topBar = {
            TopBar(
                onBackPressed = {},
                title = R.string.worlds_map_title,
                hasBackButton = false,
                onLogOutClicked = {
                    topBarViewModel.handle(TopBarEvent.LogOut)
                }
            )
        },
        content = { paddingValues ->
            if (worlds is RequestState.Success) {
                WorldsMapContent(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.secondary)
                        .padding(paddingValues),
                    worlds = worlds.data,
                    navigateToMapLevels = navigateToMapLevels
                )
            }
        }
    )
}


@DevicePreviews
@Composable
fun WorldsScreenPreview() {
    KongFuJavaTheme {
        WorldsMapScreen({})
    }
}