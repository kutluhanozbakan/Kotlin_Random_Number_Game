package com.example.note

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SonucEkrani(navController: NavController, gelenSonuc: Boolean){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        if (gelenSonuc){
            Text(text = "Kazandınız", fontSize = 36.sp)
            Image(painter = painterResource(id = R.drawable.mutlu_resim), contentDescription = "Resim_aciklama")
        }
        else{
            Text(text = "Kaybettiniz", fontSize = 36.sp)
            Image(painter = painterResource(id = R.drawable.uzgun_resim), contentDescription = "Resim_aciklama")
        }
    }
}