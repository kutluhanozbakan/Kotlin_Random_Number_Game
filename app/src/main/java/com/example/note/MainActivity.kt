package com.example.note

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.note.ui.theme.NoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                SayfaGecisleri()

                }
            }
        }
    }
}
@Composable
fun SayfaGecisleri(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "anasayfa"
           )
    {
        composable("anasayfa"){ Anasayfa(navController)}
        composable("tahmin_ekrani"){ TahminEkrani(navController)}
        composable("sonuc_ekrani/{sonuc}", arguments = listOf(
            navArgument("sonuc"){
                type= NavType.BoolType
            }
        )){
            val sonuc = it.arguments?.getBoolean("sonuc")!!
            SonucEkrani(navController,sonuc)}
    }
}
@Composable
fun Anasayfa(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
            ){
        Text(text = "Tahmin Oyunu", fontSize = 36.sp)
        Image(painter = painterResource(id = R.drawable.zar_resim), contentDescription = "zar_Resim_aciklama")
        Button(
            onClick = {
                      navController.navigate("tahmin_ekrani")
            },
            modifier = Modifier.size(
            width = 190.dp,
            height = 40.dp),
        )
        {
            Text(text = "OYUNA BAŞLA",
            fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteTheme {

    }
}