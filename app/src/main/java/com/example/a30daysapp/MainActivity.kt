package com.example.a30daysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a30daysapp.data.Datasource
import com.example.a30daysapp.model.AdventureDayModel
import com.example.a30daysapp.ui.theme._30DaysAppTheme

// Armin Vejzovic

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _30DaysAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AdventureApp()
                }
            }
        }
    }
}

@Composable
fun AdventureApp() {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        item {
            Text(
                text = "30 Days of Adventure",
                fontSize = 20.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                textAlign = TextAlign.Left,
                modifier = Modifier.fillMaxWidth()
            )
        }
        items(Datasource().adventureData) { day ->
            AdventureDayCard(day)
        }
    }
}


@Composable
fun AdventureDayCard(day: AdventureDayModel) {
    var isExpanded by remember { mutableStateOf(false) }

    Surface(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(vertical = 8.dp),
        color = if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Transparent, shape = RoundedCornerShape(8.dp))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Day ${day.number}",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Left
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = day.shortDescription,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = day.image),
                    contentDescription = "Image for Day ${day.number}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clickable { isExpanded = !isExpanded }, // Toggle visibility on click
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
                AnimatedVisibility(
                    visible = isExpanded,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Text(
                        text = day.longDescription,
                        modifier = Modifier.fillMaxWidth().animateContentSize(),
                        textAlign = TextAlign.Left
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    _30DaysAppTheme {
        AdventureApp()
    }
}