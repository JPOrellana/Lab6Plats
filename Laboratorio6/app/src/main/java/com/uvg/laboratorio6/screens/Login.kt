package com.uvg.laboratorio6.screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.laboratorio6.ui.theme.Laboratorio6Theme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio6Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    Entrar(applicationContext)
                }
            }
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_2")
@Composable
fun MainMenuPreview() {
    val context = LocalContext.current // Obtén el contexto de la vista previa
    Laboratorio6Theme {
        Surface {
            Entrar(context) // Pasa el contexto a la función Entrar
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Entrar(context: Context) {

    var email by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }

    Column{
        Text(
            text = "Mi galería",
            style = TextStyle(
                fontFamily = FontFamily.Serif,
                color = Color(0, 0, 0, 255),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(20.dp)
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "Iniciar Sesión",
            style = TextStyle(
                fontFamily = FontFamily.Serif,
                color = Color(0, 0, 0, 255),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(20.dp)
        )




        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = {Text("Ingresa tu Usuario")},
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "person")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text("Ingresa tu Constraseña")},
            leadingIcon = {
                Icon(Icons.Default.Info, contentDescription = "password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        OutlinedButton(
            onClick = {logged(email,password,context) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
                .clickable{context.startActivity(Intent(context, Galery::class.java))}
        ) {
            Text(
                text = "Ingresar",
                textAlign = TextAlign.Center
            )

        }

    }
}

fun logged(email: String, password: String, context: Context) {
    if(email=="pablo" && password == "123456"){
        Toast.makeText(context, "Ingresó Correctamente", Toast.LENGTH_SHORT).show()
    }else{
        Toast.makeText(context, "Usuario o Contraseña Incorrectos", Toast.LENGTH_SHORT).show()
    }

    if(email=="diego" && password == "123456"){
        Toast.makeText(context, "Ingresó Correctamente", Toast.LENGTH_SHORT).show()
    }else{
        Toast.makeText(context, "Usuario o Contraseña Incorrectos", Toast.LENGTH_SHORT).show()
    }

}