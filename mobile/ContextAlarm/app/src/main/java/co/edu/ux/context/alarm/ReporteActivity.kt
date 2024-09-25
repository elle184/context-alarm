package co.edu.ux.context.alarm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.edu.ux.context.alarm.ui.theme.ContextAlarmTheme

class ReporteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContextAlarmTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                    , color = MaterialTheme.colorScheme.background) {
                    Reporte()
                }
            }
        }
    }
}

@Composable
fun Reporte(modifier: Modifier = Modifier) {
    Text("Activity de reportes")
}

@Preview
@Composable
fun ReportePreview(modifier: Modifier = Modifier) {
    ContextAlarmTheme {
        Reporte()
    }
}