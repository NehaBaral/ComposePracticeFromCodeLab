package com.example.composetest

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.text.style.StyleSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class RecyclerViewPractice : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            updateScreen()
        }
    }
}

@Composable
private fun updateScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopAppBar(title = {
            Text(text = "RecyclerView Practice")
        })
        recyclerViewScreen()
    }
}

@Composable
fun recyclerViewScreen(practiceItems: List<PracticeItem> = List(100) { PracticeItem("Neha Baral", R.drawable.google, "$it") }) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = practiceItems) { practiceItem ->
            recyclerViewItem(practiceItem)
        }
    }
}

data class PracticeItem(
    val name: String,
    val image: Int,
    val desc: String
)

@Composable
fun recyclerViewItem(practiceItem: PracticeItem) {
    var expanded by remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Row(modifier = Modifier.padding(horizontal = 8.dp,vertical = 16.dp)) {
        Image(
            painter = painterResource(id = practiceItem.image),
            contentDescription = "ItemDesc",
            modifier = Modifier
                .size(40.dp)
                .clip(shape = CircleShape)
        )
        Column(modifier = Modifier
            .weight(1f)
            .padding(horizontal = 16.dp)) {
            Text(text = practiceItem.name)
            Text(text = practiceItem.desc)
        }
        Button(onClick = {
            expanded = !expanded
        }) {
            Icon(imageVector = Icons.Filled.Cancel, contentDescription = "")
        }
        if (expanded) extraPadding else 0.dp
    }
}


@Preview
@Composable
private fun previewScreen() {
    updateScreen()
}