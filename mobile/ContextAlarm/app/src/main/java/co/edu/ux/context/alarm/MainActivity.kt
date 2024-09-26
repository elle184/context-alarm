package co.edu.ux.context.alarm

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContextAlarmTheme {
                Surface(modifier = Modifier.fillMaxSize()
                    , color = MaterialTheme.colorScheme.background) {
                    AlarmsList()
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
        IconButton(onClick = { /*TODO*/ }) {
            Icon(painter = image, contentDescription = null, Modifier.size(50.dp))
        }
    }
}

@Composable
fun SwitchAlarmState(modifier: Modifier) {
    val switchChecked by remember { mutableStateOf(true) }

    Switch(checked = true, onCheckedChange = null, modifier = modifier)
}

@Composable
private fun NavigationBarContextAlarm(modifier: Modifier = Modifier) {
    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.alarm_icon)
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
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.user_icon)
                    , contentDescription = null)
            }
            , label = {
                Text(
                    text = "Alarmas"
                )
            }
            , selected = false
            , onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.report_icon)
                    , contentDescription = null)
            }
            , label = {
                Text(
                    text = "Alarmas"
                )
            }
            , selected = false
            , onClick = {}
        )
    }
}

@Composable
fun Alarms(modifier: Modifier = Modifier) {
    var alarms = mutableListOf(
        Alarm("Alarma 1", "Ringtone 1", "L-M-V", "12", minutes = "30")
        , Alarm("Alarma 2", "Ringtone 2", "L-M-V", "12", minutes = "31")
        , Alarm("Alarma 3", "Ringtone 3", "L-M-V", "12" , minutes = "30")
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
        , modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clip(MaterialTheme.shapes.small)) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                Text(text = alarm.name
                    , fontWeight = FontWeight.Bold
                    , fontSize = 22.sp
                    , color = Color(0xFF27042B))
                Row {
                    AddImage(
                        painterResource(id = R.drawable.ringtone_icon)
                        , modifier = Modifier.size(25.dp))
                    Text(text = alarm.ringtone, color = Color(0xFF27042B))
                }
                Text(text = alarm.frequency, color = Color(0xFF27042B))
            }
            Column {
                Text(text = alarm.hour
                    , fontSize = 50.sp
                    , fontWeight = FontWeight.Bold
                    , color = Color(0xFF27042B))
                Text(text = alarm.minutes
                    , fontSize = 50.sp
                    , fontWeight = FontWeight.Bold
                    , color = Color(0xFF27042B))
            }
            SwitchAlarmState(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 10.dp))
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
fun AlarmsList(
    //navController: NavHostController = rememberNavController()
) {
    ContextAlarmTheme {
        Box(Modifier.background(
            Brush.verticalGradient(
                listOf(Color(0xFF985D9C), Color(0xFF27042B))))) {
            Scaffold(
                bottomBar = { NavigationBarContextAlarm() }
                , containerColor = Color.Transparent
            ) { padding ->
                ContextAlarm(modifier = Modifier.padding(padding))
            }
        }
    }
}