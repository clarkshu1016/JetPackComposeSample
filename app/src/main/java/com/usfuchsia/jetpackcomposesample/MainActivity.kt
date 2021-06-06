package com.usfuchsia.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.usfuchsia.jetpackcomposesample.ui.theme.JetPackComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    testColumn(test = "hahahha")
//                    testColum2()
//                    ImageCard(
//                        painter = painterResource(id = R.drawable.wwww),
//                        contentDescription = "this is content Description",
//                        title = "this is Title"
//                    )
                    testImage()
                }
            }
        }
    }
}

@Composable
fun testImage() {
    Column(
        modifier = Modifier
            .background(color = Color(0xfff2f2f2))
            .fillMaxHeight()
            .fillMaxWidth()
            .verticalScroll(enabled = true, state = ScrollState(0))
        // must be last,otherwise background property not working
    )
    {
        Image(
            painter = painterResource(id = R.drawable.happy_meal_small),
            contentDescription = "happy meal small",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xeeffeeff))
                    .padding(6.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Happy Meal",
                    style = TextStyle(color = Color.Gray, fontSize = 20.sp)
                )
                Text(text = "$5.99", style = TextStyle(color = Color.Green, fontSize = 16.sp)
                    ,modifier = Modifier.align(Alignment.CenterVertically))

            }
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(text = "800 Calories", style = TextStyle(color = Color.Black, fontSize = 16.sp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.CenterHorizontally),
            ) {
                Text(text = "Order Now")
            }
        }
    }

}


@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box() {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            )
                        )
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }

        }
    }
}


@Composable
fun testColumn(test: String) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxHeight(0.75f)
            .fillMaxWidth(0.85f)
            .border(5.dp, Color.Magenta)
            .border(10.dp, Color.Green),
        verticalArrangement = Arrangement.Center
    ) {
//        Text(text = "Hello $test!",modifier = Modifier.offset(100.dp,20.dp))
        Text(text = "this is second ")
        Text(text = "this is third")
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "this is fourth", modifier = Modifier.clickable {
        })
    }
}


@Composable
fun testColum2() {
    Column(
        modifier = Modifier
            .background(Color.Gray)
            .width(600.dp)
            .fillMaxHeight(0.5f)
    )
    {
        Text(text = "hahhahah")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeSampleTheme {
        testColumn("Android")
    }
}