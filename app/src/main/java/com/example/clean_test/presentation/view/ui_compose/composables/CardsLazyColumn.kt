package com.example.clean_test.presentation.view.ui_compose.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.clean_test.R
import com.example.clean_test.domain.entities.Proverbs

private val elevatedCarModifier = Modifier
    .padding(start = 10.dp, end = 10.dp)
    .fillMaxWidth()


@Composable
fun CardsLazyColumnView(proverbsList: List<Proverbs>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxSize(0.9f)
    ) {
        items(proverbsList) { proverb ->
            setElevatedCardWith(proverb)
        }
    }
}

@Composable
fun setPictureOnElevatedCard(pictureURL: String) {
    Image(
        painter = rememberAsyncImagePainter(model = pictureURL),
        contentDescription = "proverbs description",
        modifier = Modifier
            .size(80.dp)
            .fillMaxSize()
            .height(intrinsicSize = IntrinsicSize.Max),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun setElevatedCardWith(currentProverb: Proverbs) {
    ElevatedCard(modifier = elevatedCarModifier) {
        Row {
            setPictureOnElevatedCard("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/female/25.png")
            Text(
                currentProverb.toString(),
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, bottom = 5.dp)
                    .fillMaxSize()
            )
        }
    }
}