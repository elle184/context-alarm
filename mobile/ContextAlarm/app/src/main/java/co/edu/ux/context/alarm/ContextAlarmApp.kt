package co.edu.ux.context.alarm

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ContextAlarmApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "alarms") {
        composable("createAlarm") { CreateAlarm(navController) }
        composable("alarms") { Alarms(navController) }
    }
}