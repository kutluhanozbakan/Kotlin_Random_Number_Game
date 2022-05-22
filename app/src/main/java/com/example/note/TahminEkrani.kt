package com.example.note

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random

@Composable
fun TahminEkrani(navController: NavController){
    val tfTahmin = remember { mutableStateOf("")}
    val kalanHak = remember { mutableStateOf(5) }
    val yonlendirme = remember { mutableStateOf("") }
    val rastgeleSayi = remember { mutableStateOf(0) }

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        LaunchedEffect(key1 = true){
            rastgeleSayi.value = Random.nextInt(101)//0 ile 100 arasında sayı üret
            Log.e("Rasgele Sayi:",rastgeleSayi.value.toString())
        }
        Text(text = "Kalan Hak : ${kalanHak.value}",
            fontSize = 36.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold
        )
        Text(text = "Yardım : ${yonlendirme.value}",
            fontSize = 24.sp,
        )
        TextField(value = tfTahmin.value, onValueChange = {tfTahmin.value = it},
        label = { Text(text = "Tahmin")})
        Button(
            onClick = {
                kalanHak.value = kalanHak.value - 1;
                val tahmin = tfTahmin.value.toInt()
                if (tahmin == rastgeleSayi.value)
                {
                    navController.navigate("sonuc_ekrani/true"){
                        popUpTo("tahmin_ekrani")
                        {
                            inclusive=true
                        }
                }

                }
                if (tahmin > rastgeleSayi.value)
                {
                    yonlendirme.value = "Azalt"

                }
                if (tahmin < rastgeleSayi.value)
                {
                    yonlendirme.value = "Arttır"

                }

                if(kalanHak.value == 0)
                {
                     navController.navigate("sonuc_ekrani/false"){
                popUpTo("tahmin_ekrani")
                {
                    inclusive=true
                }
               }
                }
            },
            modifier = Modifier.size(
                width = 150.dp,
                height = 50.dp),
        )
        {
            Text(text = "TAHMİN ET",
                fontWeight = FontWeight.Bold)
        }
    }
}