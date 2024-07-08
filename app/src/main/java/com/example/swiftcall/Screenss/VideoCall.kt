package com.example.swiftcall.Screenss

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CallToAction
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.swiftcall.ui.theme.Pink80



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VideoCall()
{
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Pink80
            ) {
                IconButton(
                    onClick = {}, modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.VideoCall , contentDescription = null, modifier = Modifier.size(30.dp), tint = Color.Black)
                }


                IconButton(
                    onClick = {}, modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.CallToAction , contentDescription = null, modifier = Modifier.size(30.dp), tint = Color.Gray)
                }


                IconButton(
                    onClick = {}, modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Settings , contentDescription = null, modifier = Modifier.size(30.dp), tint = Color.Gray)
                }

            }
        }
    )
    {
        //--------------------------><
    }
}

