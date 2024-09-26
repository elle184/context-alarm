package co.edu.ux.context.alarm

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ContextAlarmApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "alarms") {
        composable("createAlarm") { CreateAlarm(navController) }
        composable("alarms") { Alarms(navController) }
        composable("reports") { InformesScreen(navController) }
        composable("sonido") { SonidoScreen(navController) }
        composable("fondoPantalla") { AlarmDetailScreen(navController) }
    }
}