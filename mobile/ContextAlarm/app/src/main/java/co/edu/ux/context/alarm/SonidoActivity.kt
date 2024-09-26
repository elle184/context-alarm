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
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.Typeface




class SonidoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContextAlarmTheme {
                Surface(modifier = Modifier.fillMaxSize()
                    , color = MaterialTheme.colorScheme.background) {
                    SonidoScreen()
                }
            }
        }
    }
}


@Composable
fun Greeting4(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    ContextAlarmTheme {
        SonidoScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SonidoScreen(){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFB838E7)), // Color de fondo
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Sonido de alarma",
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
                            .clickable { /* Acción al hacer clic */ }
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFFB838E7))
            )
        },
        bottomBar = {
            NavigationBar(modifier = Modifier.height(66.dp)
            ) {
                NavigationBarItem(
                    icon = { Icon(
                        painterResource(id = R.drawable.access_alarm),
                        modifier = Modifier.size(26.dp),
                        contentDescription = "Alarmas") }, // Icono de alarmas
                    label = { Text("Alarmas",fontSize = 12.sp) },
                    selected = true,
                    onClick = { /* Acción para Alarmas */ }
                )
                NavigationBarItem(
                    icon = { Icon(
                        painterResource(id = R.drawable.access_perfil),
                        modifier = Modifier.size(26.dp),
                        contentDescription = "Perfil") }, // Icono de perfil
                    label = { Text("Perfil",fontSize = 12.sp) },
                    selected = false,
                    onClick = { /* Acción para Perfil */ }
                )
                NavigationBarItem(
                    icon = { Icon(
                        painterResource(id = R.drawable.acces_informes),
                        modifier = Modifier.size(26.dp),
                        contentDescription = "Informes") }, // Icono de informes
                    label = { Text("Informes",fontSize = 12.sp) },
                    selected = false,
                    onClick = { /* Acción para Informes */ }
                )
            }
        }
    ){ paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(
                color = Color(0xFFB838E7),
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xD9D9D9).copy(alpha = 0.33f),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Activado",
                                fontSize = 14.sp,
                                //fontFamily = FontFamily(Typeface.create("Roboto", Typeface.NORMAL)),
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                modifier = Modifier.weight(1f)
                            )
                            Switch(
                                checked = true, // Estado del switch
                                onCheckedChange = { /* Acción al cambiar el estado */ },
                                modifier = Modifier
                                    .size(42.dp, 22.dp),
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color.White,
                                    uncheckedThumbColor = Color.White,
                                    checkedTrackColor = Color(0xFFB838E7),
                                    uncheckedTrackColor = Color(0xFFB838E7)
                                )
                            )
                        }   }
                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0x25B838E7))
                    .padding(vertical = 20.dp),
                    verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        painter = painterResource(id = R.drawable.linea), // Icono de música
                        contentDescription = "Linea",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(start = 60.dp)
                            .width(280.dp)  // Ancho de la línea
                            .height(1.dp)
                    )
                }

                // Tono - Homecoming
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0x25B838E7))
                        .padding(vertical = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.queue_music), // Icono de música
                        contentDescription = "Tono",
                        tint = Color.White,
                        modifier = Modifier
                                    .padding(start = 15.dp)
                                    .size(32.dp)

                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 15.dp) // Ajusta el padding izquierdo según sea necesario
                    ) {
                        Text(
                            text = "Tono",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold, // Texto semibold
                            color = Color.White
                        )
                        Text(
                            text = "Homecoming",
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.chulo), // Icono de selección
                        contentDescription = "Seleccionado",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(start = 150.dp)
                            .size(25.dp)
                    )
                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0x25B838E7))
                    .padding(vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        painter = painterResource(id = R.drawable.linea), // Icono de música
                        contentDescription = "Linea",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(start = 60.dp)
                            .width(280.dp)  // Ancho de la línea
                            .height(1.dp)
                    )
                }

                // Tono - Homecoming
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.queue_music), // Icono de música
                        contentDescription = "Tono",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(start = 15.dp)
                            .size(32.dp)

                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 15.dp) // Ajusta el padding izquierdo según sea necesario
                    ) {
                        Text(
                            text = "Spotify",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold, // Texto semibold
                            color = Color.White
                        )
                        Text(
                            text = "Metallica",
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0x25B838E7))
                    .padding(vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        painter = painterResource(id = R.drawable.linea), // Icono de música
                        contentDescription = "Linea",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(start = 60.dp)
                            .width(280.dp)  // Ancho de la línea
                            .height(1.dp)
                    )
                }
            }

        }
    }
}



