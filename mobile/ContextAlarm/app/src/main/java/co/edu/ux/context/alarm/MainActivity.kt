package co.edu.ux.context.alarm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import co.edu.ux.context.alarm.ui.theme.ContextAlarmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContextAlarmTheme {
                Surface(modifier = Modifier.fillMaxSize()
                    , color = MaterialTheme.colorScheme.background) {
                    ContextAlarmApp()
                }
            }
        }
    }
}