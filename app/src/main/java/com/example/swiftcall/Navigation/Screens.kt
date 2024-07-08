package com.example.swiftcall.Navigation

sealed class Screens( var route: String) {

    object loginScreen : Screens("login")
    object otpScreen : Screens("otp")
    object homeScreen : Screens("home")

    object videoCall : Screens("videocall")


}