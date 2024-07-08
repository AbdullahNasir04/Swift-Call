package com.example.swiftcall.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.swiftcall.Screenss.LoginScreen
import com.example.swiftcall.Screenss.OtpScreen
import com.example.swiftcall.Screenss.VideoCall
import com.example.swiftcall.ViewModels.LoginViewModel

@Composable
fun NavGraph(){
    val navController = rememberNavController()
    val lvm = LoginViewModel()
    NavHost(navController = navController, startDestination = Screens.loginScreen.route ){

        composable(Screens.loginScreen.route){ LoginScreen(navController,lvm)}
        composable(Screens.otpScreen.route){ OtpScreen(navController, lvm)}

        composable(Screens.videoCall.route){ VideoCall() }

    }
}