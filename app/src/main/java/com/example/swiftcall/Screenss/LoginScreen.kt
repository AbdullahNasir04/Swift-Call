package com.example.swiftcall.Screenss

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.swiftcall.Navigation.Screens
import com.example.swiftcall.R
import com.example.swiftcall.ViewModels.LoginViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun LoginScreen(navController:NavController,lvm:LoginViewModel) {


    val uusseerr by remember { mutableStateOf(Firebase.auth.currentUser) }
    val context = LocalContext.current
    var phoneNum by remember { mutableStateOf("") }
    val bgColor = Color(0xFF6650a4)
    val Pink80 = Color(0xFFEFB8C8)
    val tColor = Color(0xFFECFADC)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        if (uusseerr == null) {
            Text(
                text = "Authentication",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = tColor
            )

            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "we will send you one time password", color = tColor)
            Text(text = "on your phone number", color = tColor)
            Text(text = "for verification", color = tColor)
            Spacer(modifier = Modifier.size(50.dp))

            OutlinedTextField(
                value = phoneNum, onValueChange = { if (it.length <= 10) phoneNum = it },
                label = { Text(text = "enter phone number", color = tColor) },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = bgColor,
                    unfocusedContainerColor = bgColor,
                    focusedIndicatorColor = tColor,
                    cursorColor = tColor
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                textStyle = TextStyle(color = tColor)
            )
            Spacer(modifier = Modifier.size(50.dp))
            Button(
                onClick = {
                    if (phoneNum.isEmpty()) {
                        Toast.makeText(context, "Please enter number", Toast.LENGTH_SHORT).show()
                    } else {
                        lvm.onLoginClicked(context, navController, phoneNum)
                        {
                            Log.d("phoneBook", "sending opt")
                            navController.navigate("otp")
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(Pink80)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    Image(
                        painter = painterResource(id = R.drawable.otp),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Send O.T.P",
                        color = Color.Black
                    )
                }
            }
        } else {
            navController.navigate(Screens.videoCall.route)
        }
    }
}









