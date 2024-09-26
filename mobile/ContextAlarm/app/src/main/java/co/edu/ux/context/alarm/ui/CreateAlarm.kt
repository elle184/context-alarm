package co.edu.ux.context.alarm

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import co.edu.ux.context.alarm.ui.theme.ContextAlarmTheme
import java.util.Calendar

@Composable
fun CreateAlarm(navController: NavController) {
    Box(
        Modifier.background(
                Brush.verticalGradient(
                    listOf(Color(0xFF985D9C), Color(0xFF27042B))
                )
            )) {
        Scaffold(
            bottomBar = { NavigationBarContextAlarm(navController) },
            containerColor = Color.Transparent
        ) { padding ->
                Column(Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                    SelectHour(onConfirm = { /*TODO*/ }) { }
                    SelectWeekdays({}, Modifier.padding(horizontal = 1.dp))
                    SelectRingtone(Modifier.padding(horizontal = 8.dp, vertical = 8.dp))
                    SelectVibration(Modifier.padding(horizontal = 8.dp, vertical = 8.dp))
                    SelectReminder(Modifier.padding(horizontal = 8.dp, vertical = 8.dp))
                    SelectBackground(Modifier.padding(horizontal = 8.dp, vertical = 8.dp))
                    NotifyReminder(Modifier.padding(horizontal = 8.dp, vertical = 8.dp))
                    SelectLocation(Modifier.padding(horizontal = 8.dp, vertical = 8.dp))
                }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectHour(onConfirm: () -> Unit, onDismiss: () -> Unit) {
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = false,
    )

    TimeInput(state = timePickerState)
}

@Composable
fun SelectWeekdays(onClick: () -> Unit, modifier: Modifier) {
    Row(modifier) {
        TextButton(onClick = { /*TODO*/ }, modifier) { Text("L" ) }
        TextButton(onClick = { /*TODO*/ }, modifier) { Text("M") }
        TextButton(onClick = { /*TODO*/ }, modifier) { Text("M") }
        TextButton(onClick = { /*TODO*/ }, modifier) { Text("J") }
        TextButton(onClick = { /*TODO*/ }, modifier) { Text("V") }
        TextButton(onClick = { /*TODO*/ }, modifier) { Text("S") }
        TextButton(onClick = { /*TODO*/ }, modifier) { Text("D") }
    }
}

@Composable
fun SelectRingtone(modifier: Modifier) {
    Row(modifier) {
        Column {
            Text("Sonido de alarma")
            Text("November rain - Guns N Roses"
                , fontSize = 10.sp)
        }
        SwitchAlarmState(modifier = Modifier
            .align(Alignment.CenterVertically)
            .padding(start = 90.dp))
    }
}

@Composable
fun SelectVibration(modifier: Modifier) {
    Row(modifier) {
        Column {
            Text("Vibración")
        }
        SwitchAlarmState(modifier = Modifier
            .align(Alignment.CenterVertically)
            .padding(start = 165.dp))
    }
}

@Composable
fun SelectReminder(modifier: Modifier) {
    Row(modifier) {
        Column {
            Text("Recordatorio")
        }
        SwitchAlarmState(modifier = Modifier
            .align(Alignment.CenterVertically)
            .padding(start = 140.dp))
    }
}

@Composable
fun SelectBackground(modifier: Modifier) {
    Column(modifier) {
        Text("Fondo de la alarma")
        Image(
            painterResource(id = R.drawable.background_alarm_preview)
            , contentDescription = null
        )
    }
}

@Composable
fun NotifyReminder(modifier: Modifier) {
    var selectedIndex = remember { mutableStateOf(0) }
    val options = listOf("Hora(s)", "Día(s)", "Semana(s)", "Mes(es)")

    Column {
        Text("Notificar recordatorio")
        SingleChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                    onClick = {  },
                    selected = false
                ) {
                    Text(label, fontSize = 10.sp)
                }
            }
        }
    }
}

@Composable
fun SelectLocation(modifier: Modifier) {
    Column(modifier) {
        Text("¿Necesita llegar a algún sitio?")
        Image(
            painterResource(id = R.drawable.google_maps_sample)
            , contentDescription = null
        )
    }
}

@Preview(
    showBackground = true
    , widthDp = 320
    , uiMode = Configuration.UI_MODE_NIGHT_YES
    , name = "GreetingPreviewDark"
)
@Composable
fun CreateAlarmPreview() {
    ContextAlarmTheme {
        CreateAlarm(navController = rememberNavController())
    }
}