package dorin_roman.app.kongfujava.screens.supervisor.progress_report

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dorin_roman.app.kongfujava.screens.supervisor.StudentModel
import dorin_roman.app.kongfujava.ui.components.DevicePreviews
import dorin_roman.app.kongfujava.ui.theme.KongFuJavaTheme

@Composable
fun SupervisorProgressReportScreen(
    modifier: Modifier = Modifier,
    studentModel: StudentModel,
    viewModel: SupervisorProgressReportViewModel = hiltViewModel()
) {
    LaunchedEffect(studentModel) {
        viewModel.handle(SupervisorProgressReportEvent.UpdateSelectedStudent(studentModel))
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Progress Report screen - temp UI",
            style = MaterialTheme.typography.h3
        )
        Text(
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.h5,
            text = "id: ${viewModel.selectedStudent.id}"
        )
        Text(
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.h5,
            text = "name: ${viewModel.selectedStudent.name}"
        )
        Text(
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.h5,
            text = "age: ${viewModel.selectedStudent.age}"
        )
        Text(
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.h5,
            text = "Private Code: ${viewModel.selectedStudent.privateCode}"
        )
    }
}

@DevicePreviews
@Composable
fun SupervisorProgressReportScreenPreview() {
    KongFuJavaTheme {
        SupervisorProgressReportScreen(
            studentModel = StudentModel(
                id = "id",
                name = "name",
                age = 10,
                privateCode = "ABCDEF",
                selected = true
            )
        )
    }
}