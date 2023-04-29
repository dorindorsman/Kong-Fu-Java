package dorin_roman.app.kongfujava.screens.level.drag_drop.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dorin_roman.app.kongfujava.screens.level.drag_drop.DragDropViewModel

@Composable
fun DragDropLeftBottomScreenContent(dragDropViewModel: DragDropViewModel) {

    val gridState = rememberLazyGridState()
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center,
            state = gridState,
            userScrollEnabled = false,
        ) {
            items(dragDropViewModel.drag) { answerItem->
                DragItem(
                    dataToDrop = answerItem,
                    viewModel = dragDropViewModel
                ) {
                    DragAnswerItemCard(answer = answerItem)
                }
            }
        }

}