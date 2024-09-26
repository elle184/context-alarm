package co.edu.ux.context.alarm


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.ux.context.alarm.ui.theme.ContextAlarmTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.border
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

class FondoPantalla : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContextAlarmTheme {
                Surface(modifier = Modifier.fillMaxSize()
                    , color = MaterialTheme.colorScheme.background) {
                    AlarmDetailScreen(rememberNavController())
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ContextAlarmTheme {
        AlarmDetailScreen(rememberNavController())
    }
}

@Composable
fun AlarmDetailScreen(navController : NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background( Brush.verticalGradient(
                listOf(Color(0xFF985D9C), Color(0xFF27042B)))) // Fondo morado que rodea la pantalla
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = R.drawable.imagenmoto),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(0.99f)
                .padding(16.dp),
            contentScale = ContentScale.Crop
        )

        // Botones "Fondo" y "Realizado" en la parte superior
        Row(
            horizontalArrangement = Arrangement.spacedBy(85.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 40.dp)
        ) {
            // Botón "Fondo"
            Button(
                onClick = { /* Acción del botón */ },
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.size(110.dp, 35.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF985D9C))
            ) {
                Text( text = "Fondo",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    //fontFamily = kantumruyPro,
                    color = Color.White)
            }

            // Botón "Realizado"
            Button(
                onClick = { navController.navigate("alarms")},
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.size(110.dp, 35.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFE299CE))
            ) {
                Text(text = "Realizado",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    //fontFamily = kantumruyPro,
                    color = Color.White)
            }
        }

        // Hora y fecha en el centro
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 150.dp)
                .fillMaxWidth()
        ) {
            // Caja para hora y fecha
            Box(
                modifier = Modifier
                    .size(width = 163.dp, height = 85.dp)
                    .background(Color(0xFF7D7A7A).copy(alpha = 0.5f), RoundedCornerShape(5.dp))
                    .border(
                        BorderStroke(1.dp, Color(0xFFB9B9B9)),
                        RoundedCornerShape(5.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Texto de la hora
                    Text(
                        text = "12:00", // Hora
                        fontSize = 32.sp,
                        fontWeight = FontWeight.SemiBold,
                        //fontFamily = kantumruyPro,
                        color = Color.White
                    )

                    // Texto de la fecha
                    Text(
                        text = "Vie, 30 sep", // Fecha
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        //fontFamily = kantumruyPro,
                        color = Color.White
                    )
                }
        }   }
    }
}