package com.example.composetest

import android.graphics.drawable.PaintDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ImageSearch
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.ui.BasicsCodelabTheme

class LoginScreen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            updateLoginScreen()
        }
    }
}

@Composable
fun updateLoginScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        //   verticalArrangement = Arrangement.Center
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(backgroundColor = Color.White, elevation = 0.dp, modifier = Modifier
            .fillMaxWidth()
            .height(24.dp), title = {
            Text(text = "Fam")
        })
        loginContent()
    }
}

@Composable
fun loginContent() {
    val inputvalue = remember { mutableStateOf(TextFieldValue()) }
    Spacer(modifier = Modifier.size(50.dp))
    Text(text = "Log in to fam", style = TextStyle(fontSize = 24f.sp))

    OutlinedButton(onClick = { /*TODO*/ }, Modifier.padding(10.dp), shape = RoundedCornerShape(30.dp)) {
        Image(
            painter = painterResource(id = R.drawable.apple_logo),
            contentDescription = "",
            modifier = Modifier.size(40.dp)
        )
        Text(text = "Continue with Apple", color = Color.Black)
    }

    OutlinedButton(onClick = { /*TODO*/ }, Modifier.padding(10.dp), shape = RoundedCornerShape(30.dp)) {
        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription = "",
            modifier = Modifier.size(40.dp)
        )
        Text(text = "Continue with Google", color = Color.Black)
    }

    Row(Modifier.padding(10.dp)) {
        Divider(
            color = Color.Blue, thickness = 1.dp,
            modifier = Modifier
                .weight(1f)
                .padding(10.dp),
        )
        Text(text = "OR", style = TextStyle(fontSize = 13f.sp))
        Divider(
            color = Color.Blue, thickness = 1.dp, modifier = Modifier
                .weight(1f)
                .padding(10.dp)
        )
    }

    OutlinedTextField(value = inputvalue.value,
        onValueChange = {
            inputvalue.value = it
        }, placeholder = { Text(text = "Email") }, shape = RoundedCornerShape(1)
    )

    OutlinedTextField(value = inputvalue.value,
        onValueChange = {
            inputvalue.value = it
        }, placeholder = { Text(text = "Password") }, shape = RoundedCornerShape(1)
    )

    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 60.dp, vertical = 20.dp)
    ) {
        Text(text = "LOG IN")
    }

    Text(text = "Forgot password?")
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    updateLoginScreen()
}
