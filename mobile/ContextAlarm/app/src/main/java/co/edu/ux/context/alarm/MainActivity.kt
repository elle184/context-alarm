package co.edu.ux.context.alarm

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.ux.context.alarm.data.Alarm
import co.edu.ux.context.alarm.ui.theme.ContextAlarmTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold

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
fun AddImage(
    image: Painter
    , modifier: Modifier = Modifier) {
    Box {
        Image(painter = image, contentDescription = null
            , modifier = modifier)
    }
}

@Composable
fun SwitchAlarmState() {
    val switchChecked by remember { mutableStateOf(true) }

    Switch(checked = true, onCheckedChange = null)
}

@Composable
private fun NavigationBarContextAlarm(modifier: Modifier = Modifier) {
    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home
                    , contentDescription = null)
            }
            , label = {
                Text(
                    text = "Alarmas"
                )
            }
            , selected = true
            , onClick = {}
        )
    }
}

@Composable
fun Alarms(modifier: Modifier = Modifier) {
    var alarms = mutableListOf(
        Alarm("Alarma 1", "Ringtone 1", "L-M-V", "12:00")
        , Alarm("Alarma 2", "Ringtone 2", "L-M-V", "12:00")
        , Alarm("Alarma 3", "Ringtone 3", "L-M-V", "12:00")
    )

    Column {
        Row(modifier = Modifier.padding(8.dp))  {
            AddImage(
                painterResource(id = R.drawable.context_alarm_logo)
                , modifier = modifier)
        }
        Row(modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)) {
            Column(modifier = Modifier
                .weight(1f)) {

            }
            AddImage(
                painterResource(id = R.drawable.button_add)
                , modifier = Modifier.size(50.dp))
        }
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            items(items = alarms) { alarm ->
                Greeting(alarm = alarm)
            }
        }

    }
}

@Composable
fun Greeting(alarm: Alarm, modifier: Modifier = Modifier) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(color = Color(0xFF985D9C)
        , modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                Text(text = alarm.name)
                Text(text = alarm.ringtone)
                Text(text = alarm.frequency)
            }
            Text(text = alarm.hour)
            SwitchAlarmState()
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
        Scaffold(
            bottomBar = { NavigationBarContextAlarm() }
        ) { padding ->
            ContextAlarm(modifier = Modifier.padding(padding))
        }
    }
}