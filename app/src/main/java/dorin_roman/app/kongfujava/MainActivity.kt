package dorin_roman.app.kongfujava

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import dorin_roman.app.kongfujava.ui.components.SystemUi
import dorin_roman.app.kongfujava.ui.theme.KongFuJavaTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)

        setContent {
            KongFuJavaTheme {
                SystemUi()
                MainScreen()
            }
        }
    }
}