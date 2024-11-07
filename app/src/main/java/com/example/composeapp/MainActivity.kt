package com.example.composeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
        Column {
            Text(text = "About Me", fontSize = 20.sp, fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = description, fontSize = 16.sp, fontStyle = FontStyle.Italic)
            Button(
                onClick = {
                    Toast.makeText(
                        this@MainActivity,
                        "You can't edit text in this version of the app",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                modifier = Modifier.align(Alignment.End)
            ) { Text(text = "Edit Profile") }
        }
    }

    @Composable
    fun Interest() {
        Column(verticalArrangement = Arrangement.SpaceEvenly) {
            Text(
                text = "Interests",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(0.dp, 8.dp)
            )
            Row {
                Icon(
                    painter = painterResource(R.drawable.ic_music),
                    contentDescription = "Music",
                )
                Text(
                    text = "Music", fontSize = 16.sp,
                    modifier = Modifier.padding(4.dp, 0.dp)
                )
            }
            Row {
                Icon(
                    painter = painterResource(R.drawable.ic_gaming),
                    contentDescription = "Gaming"
                )
                Text(
                    text = "Gaming", fontSize = 16.sp,
                    modifier = Modifier.padding(4.dp, 0.dp)
                )
            }
            Row {
                Icon(
                    painter = painterResource(R.drawable.ic_gymnastics),
                    contentDescription = "Sports"
                )
                Text(
                    text = "Sports", fontSize = 16.sp,
                    modifier = Modifier.padding(4.dp, 0.dp)
                )
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
                        .size(60.dp)
                        .clip(CircleShape)
                        .border(1.dp, color = Color.Gray, CircleShape)
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DesignPreview() {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(12.dp)
        ) {
            User_Profile("Dzhumaliev Sultan", "Online")
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
}