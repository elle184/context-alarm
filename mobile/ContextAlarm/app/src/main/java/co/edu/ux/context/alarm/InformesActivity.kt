@file:OptIn(ExperimentalMaterial3Api::class)

package co.edu.ux.context.alarm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.edu.ux.context.alarm.ui.theme.ContextAlarmTheme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

class InformesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContextAlarmTheme {
                Surface(modifier = Modifier.fillMaxSize()
                    , color = MaterialTheme.colorScheme.background) {
                    InformesScreen(rememberNavController())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    ContextAlarmTheme {
        InformesScreen(rememberNavController())
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InformesScreen(navController : NavController) {
    Scaffold(
        modifier = Modifier.background( Brush.verticalGradient(
            listOf(Color(0xFF985D9C), Color(0xFF27042B)))), // Color de fondo
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Informes",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                        )
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.back_arrow),
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(21.dp, 26.dp)
                            .clickable { navController.popBackStack() }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF985D9C))
            )
        },
        bottomBar = {
            NavigationBar(modifier = Modifier.height(66.dp)
            ) {
                NavigationBarItem(
                    icon = { Icon(painterResource(id = R.drawable.access_alarm),
                        modifier = Modifier.size(26.dp),
                        contentDescription = "Alarmas") }, // Icono de alarmas
                    label = { Text("Alarmas",fontSize = 12.sp) },
                    selected = true,
                    onClick = { navController.navigate("alarms")  }
                )
                NavigationBarItem(
                    icon = { Icon(painterResource(id = R.drawable.access_perfil),
                        modifier = Modifier.size(26.dp),
                        contentDescription = "Perfil") }, // Icono de perfil
                    label = { Text("Perfil",fontSize = 12.sp) },
                    selected = false,
                    onClick = { }
                )
                NavigationBarItem(
                    icon = { Icon(painterResource(id = R.drawable.acces_informes),
                        modifier = Modifier.size(26.dp),
                        contentDescription = "Informes") }, // Icono de informes
                    label = { Text("Informes",fontSize = 12.sp) },
                    selected = false,
                    onClick = { navController.navigate("reports") }
                )
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF985D9C), Color(0xFF27042B))
                ),
            )
        ) {
            InformesList()
        }
    }
}

@Composable
fun InformesList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .background(
                color = Color(0x15985D9C), // Color de fondo del número
                shape = RoundedCornerShape(4.dp)
            ),
    ) {
        items(3) {
            InformeItem(
                title = "Título ContextAlarma",
                attendedCount = 5,
                snoozedCount = 4,
                missedCount = 3
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun InformeItem(title: String, attendedCount: Int, snoozedCount: Int, missedCount: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0x20985D9C), // Fondo con algo de transparencia
                shape = RoundedCornerShape(0.dp)
            )
            .padding(16.dp)
    ) {
        // Título de la alarma
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Columna para las estadísticas (cada una en su fila)
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp), // Espaciado entre filas
            modifier = Modifier.fillMaxWidth()
        ) {
            StatItem(count = attendedCount, label = "Veces atendidas")
            StatItem(count = snoozedCount, label = "Veces postergadas")
            StatItem(count = missedCount, label = "Veces sin Atender")
        }
    }
}

@Composable
fun StatItem(count: Int, label: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(30.dp)
                .background(
                    color = Color(0x50985D9C), // Color de fondo del número
                    shape = RoundedCornerShape(4.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = count.toString(),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label, fontSize = 14.sp, color = Color.White)
    }
}