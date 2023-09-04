package com.uvg.laboratorio6.screens
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.laboratorio6.R
import com.uvg.laboratorio6.ui.theme.Laboratorio6Theme

class ArtGallery : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSharedPreferences("ArtSpacePrefs", Context.MODE_PRIVATE)
        setContent {
            Laboratorio6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Laboratorio6Theme {
        ArtSpace()
    }
}

@Composable
fun ArtSpace() {
    val art1 = R.drawable.obra1
    val art2 = R.drawable.obra2
    val art3 = R.drawable.obra3
    val art4 = R.drawable.obra4
    val art5 = R.drawable.obra5
    val art6 = R.drawable.obra6
    val art7 = R.drawable.obra7
    val art8 = R.drawable.obra8
    val art9 = R.drawable.obra9
    val art10 = R.drawable.obra10

    val context = LocalContext.current

    var title by remember { mutableStateOf(R.string.art1_name) }
    var published by remember { mutableStateOf(R.string.art1_year) }
    var author by remember { mutableStateOf(R.string.art1_author) }
    var currentArtwork by remember { mutableStateOf(art1) }

    Column {
        Box (modifier = Modifier.fillMaxSize()){
            Image(
                painter = painterResource(id = R.drawable.fondo),
                contentDescription = "app background",
                contentScale = ContentScale.FillBounds,
                alpha = 0.5F,
                modifier = Modifier.matchParentSize()
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxSize()
            ) {

                Row (modifier = Modifier.weight(1.0F)){
                    ArtworkDisplay(currentArtwork = currentArtwork)
                }

                Spacer(modifier = Modifier.size(16.dp))

                ArtworkInfo(title = title, year = published, author = author )

                Spacer(modifier = Modifier.size(25.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {
                            val sharedPreferences = context.getSharedPreferences("ArtSpacePrefs", Context.MODE_PRIVATE)
                            with(sharedPreferences.edit()) {
                                putBoolean("isLoggedIn", false)
                                apply()
                            }
                            val intent = Intent(context, Login::class.java)
                            context.startActivity(intent)
                            (context as Activity).finish()
                        },
                        colors = with(ButtonDefaults) {
                            buttonColors(
                                Color.DarkGray
                            )
                        },
                        elevation = ButtonDefaults.elevatedButtonElevation(
                            defaultElevation = 2.dp,
                            pressedElevation = 0.dp,
                            focusedElevation = 1.dp
                        ),
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(
                            text = "Logout",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.LightGray
                        )
                    }
                    // Previous Button
                    Button(
                        onClick = {
                            when (currentArtwork) {
                                art1 -> {
                                    currentArtwork = art10
                                    title = R.string.art10_name
                                    published = R.string.art10_year
                                    author = R.string.art10_author
                                }
                                art2 -> {
                                    currentArtwork = art1
                                    title = R.string.art1_name
                                    published = R.string.art1_year
                                    author = R.string.art1_author
                                }
                                art3 -> {
                                    currentArtwork = art2
                                    title = R.string.art2_name
                                    published = R.string.art2_year
                                    author = R.string.art2_author
                                }
                                art4 -> {
                                    currentArtwork = art3
                                    title = R.string.art3_name
                                    published = R.string.art3_year
                                    author = R.string.art3_author
                                }
                                art5 -> {
                                    currentArtwork = art4
                                    title = R.string.art4_name
                                    published = R.string.art4_year
                                    author = R.string.art4_author
                                }
                                art6 -> {
                                    currentArtwork = art5
                                    title = R.string.art5_name
                                    published = R.string.art5_year
                                    author = R.string.art5_author
                                }
                                art7 -> {
                                    currentArtwork = art6
                                    title = R.string.art6_name
                                    published = R.string.art6_year
                                    author = R.string.art6_author
                                }
                                art8 -> {
                                    currentArtwork = art7
                                    title = R.string.art7_name
                                    published = R.string.art7_year
                                    author = R.string.art7_author
                                }
                                art9 -> {
                                    currentArtwork = art8
                                    title = R.string.art8_name
                                    published = R.string.art8_year
                                    author = R.string.art8_author
                                }
                                art10 -> {
                                    currentArtwork = art9
                                    title = R.string.art9_name
                                    published = R.string.art9_year
                                    author = R.string.art9_author
                                }
                            }
                        },
                        colors = with(ButtonDefaults) {
                            buttonColors(
                                Color.DarkGray
                            )
                        },
                        elevation = ButtonDefaults.elevatedButtonElevation(
                            defaultElevation = 2.dp,
                            pressedElevation = 0.dp,
                            focusedElevation = 1.dp
                        ),
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(
                            text = "Previous",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.LightGray
                        )
                    }

                    // Next Button
                    Button(
                        onClick = {
                            when (currentArtwork) {
                                art1 -> {
                                    currentArtwork = art2
                                    title = R.string.art2_name
                                    published = R.string.art2_year
                                    author = R.string.art2_author
                                }
                                art2 -> {
                                    currentArtwork = art3
                                    title = R.string.art3_name
                                    published = R.string.art3_year
                                    author = R.string.art3_author
                                }
                                art3 -> {
                                    currentArtwork = art4
                                    title = R.string.art4_name
                                    published = R.string.art4_year
                                    author = R.string.art4_author
                                }
                                art4 -> {
                                    currentArtwork = art5
                                    title = R.string.art5_name
                                    published = R.string.art5_year
                                    author = R.string.art5_author
                                }
                                art5 -> {
                                    currentArtwork = art6
                                    title = R.string.art6_name
                                    published = R.string.art6_year
                                    author = R.string.art6_author
                                }
                                art6 -> {
                                    currentArtwork = art7
                                    title = R.string.art7_name
                                    published = R.string.art7_year
                                    author = R.string.art7_author
                                }
                                art7 -> {
                                    currentArtwork = art8
                                    title = R.string.art8_name
                                    published = R.string.art8_year
                                    author = R.string.art8_author
                                }
                                art8 -> {
                                    currentArtwork = art9
                                    title = R.string.art9_name
                                    published = R.string.art9_year
                                    author = R.string.art9_author
                                }
                                art9 -> {
                                    currentArtwork = art10
                                    title = R.string.art10_name
                                    published = R.string.art10_year
                                    author = R.string.art10_author
                                }
                                art10 -> {
                                    currentArtwork = art1
                                    title = R.string.art1_name
                                    published = R.string.art1_year
                                    author = R.string.art1_author
                                }
                            }
                        },
                        colors = with(ButtonDefaults) {
                            buttonColors(
                                Color.DarkGray
                            )
                        },
                        elevation = ButtonDefaults.elevatedButtonElevation(
                            defaultElevation = 2.dp,
                            pressedElevation = 0.dp,
                            focusedElevation = 1.dp
                        ),
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(
                            text = "Next",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.LightGray
                        )
                    }
                }
            }
        }
    }


}

@Composable
fun ArtworkDisplay(
    @DrawableRes currentArtwork: Int
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(size = 10.dp))
            .background(color = Color.Gray)
            .border(width = 10.dp, color = Color.Gray)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxHeight()
    ){
        Image(
            painter = painterResource(currentArtwork),
            contentDescription = "Artwork Image",
            modifier = Modifier
                .fillMaxHeight()
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.FillHeight,

            )
    }
}

@Composable
fun ArtworkInfo(
    @StringRes title: Int,
    @StringRes year: Int,
    @StringRes author: Int
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(size = 10.dp))
            .background(color = Color.Gray)
        ){
            Column (
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ){
                // Artwork title
                Text(
                    text = stringResource(id = title),
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(30, 30, 30),
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(10.dp),
                    lineHeight = 40.sp
                )

                // Artwork date
                Text(
                    text = "Published on: ${stringResource(id = year)}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(10.dp)
                )

                // Artwork artist
                Text(
                    text = "By: ${stringResource(id = author)}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
            }
        }
    }
}