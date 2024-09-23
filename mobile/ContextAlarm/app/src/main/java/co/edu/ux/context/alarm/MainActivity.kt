package co.edu.ux.context.alarm

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.ux.context.alarm.ui.theme.ContextAlarmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContextAlarmTheme {
                Surface(modifier = Modifier.fillMaxSize()
                    , color = MaterialTheme.colorScheme.background) {
                    Alarms()
                }
            }
        }
    }
}

@Composable
fun ContextAlarm(modifier: Modifier = Modifier
    , alarms: List<String> = listOf("Alarma 1", "Alarma 2")) {
    Alarms()
}

@Composable
fun Alarms(modifier: Modifier = Modifier
    , alarms: List<String> = List(10) {"Alarma $it"}) {
    Column {
        Row {
            Column(modifier = Modifier.weight(1f)
                .padding(bottom = 8.dp)) {
                Text("Vacio")
            }
            Text("Crear alarma")
        }
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            items(items = alarms) { alarm ->
                Greeting(name = alarm)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(color = Color(0xFF985D9C)
        , modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                Text(text = "$name")
            }
            ElevatedButton(onClick = { expanded.value = !expanded.value }) {
                Text(if (expanded.value) "Activar" else "Desactivado")
            }
        }
    }
}

@Preview(
    showBackground = true
    , widthDp = 320
    , uiMode = Configuration.UI_MODE_NIGHT_YES
    , name = "GreetingPreviewDark"
)
@Composable
fun GreetingPreview() {
    ContextAlarmTheme {
        ContextAlarm(modifier = Modifier.fillMaxSize())
    }
}