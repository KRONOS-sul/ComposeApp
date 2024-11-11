package com.example.composeapp.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.R

@Composable
fun ProfileScreen() {

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.padding(12.dp)
    ) {
        User_Profile("Dzhumaliev Sultan", "Offline")
        About_Me(
            "I'm a motivated learner who loves coding, especially using Kotlin for " +
                    "Android development. I aim to create useful and engaging apps, like language" +
                    " learning tools and a background video player. During the day, I feel really" +
                    " driven, but I sometimes leave homework until the last minute. I can get " +
                    "sidetracked by YouTube or snacks now and then. I’m also focused on mastering" +
                    " efficiency tricks, like Android Studio hotkeys, to make my workflow smoother."
        )
        Interest()
        Friends()
    }
}

@Composable
fun User_Profile(name: String, status: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.me),
            contentDescription = "Profile picture",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(1.dp, color = Color.Gray, CircleShape)
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(start = 20.dp)
        ) {
            Text(text = name, fontSize = 24.sp, fontWeight = FontWeight.Bold)

            Row(verticalAlignment = Alignment.CenterVertically) {
                val statusColor = if (status == "Offline") Color.Gray else Color.Green
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(statusColor, CircleShape)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = status, fontSize = 18.sp, color = Color.Gray)
            }
        }
    }
}

@Composable
fun About_Me(description: String) {
    val context = LocalContext.current
    Column {
        Text(text = "About Me", fontSize = 20.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = description, fontSize = 16.sp, fontStyle = FontStyle.Italic)
        Button(modifier = Modifier.align(Alignment.End),
            onClick = {
                Toast.makeText(
                    context,
                    "You can't edit text in this version of the app",
                    Toast.LENGTH_SHORT
                ).show()
            }) { Text(text = "Edit Profile") }
    }
}

@Composable
fun Interest() {
    val icons = listOf(R.drawable.ic_music, R.drawable.ic_gaming, R.drawable.ic_gymnastics)
    val interests = listOf("Music", "Gaming", "Sports")

    Text(
        text = "Interests",
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(0.dp, 8.dp)
    )
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(icons.size) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(icons[it]),
                    contentDescription = interests[it],
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = interests[it],
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun Friends() {

    val pictures = listOf(R.drawable.img1, R.drawable.img2, R.drawable.img3)

    Spacer(modifier = Modifier.height(16.dp))
    Column(verticalArrangement = Arrangement.SpaceEvenly) {
        Text(
            text = "Friends",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(0.dp, 8.dp)
        )
    }
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(pictures.size) {
            Image(
                painter = painterResource(pictures[it]),
                contentDescription = "Profile picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.dp, color = Color.Gray, CircleShape)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview() {
    ProfileScreen()
}