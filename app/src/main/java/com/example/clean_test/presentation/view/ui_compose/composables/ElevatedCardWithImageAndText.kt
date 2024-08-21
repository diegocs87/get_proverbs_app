package com.example.clean_test.presentation.view.ui_compose.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.presentation.view.ui_compose.composables.utils.TextStyles


private val elevatedCarModifier = Modifier
    .padding(start = 10.dp, end = 10.dp)
    .fillMaxWidth()

private val rowTextModifier = Modifier
    .padding(start = 15.dp, end = 15.dp, bottom = 5.dp)
    .fillMaxSize()

private val imageModifier = Modifier
    .size(80.dp)
    .fillMaxSize()
    .height(intrinsicSize = IntrinsicSize.Max)

@Composable
fun setElevatedCardWith(currentProverb: Proverbs, pictureURL: String) {
    ElevatedCard(modifier = elevatedCarModifier) {
        Row {
            setPictureOnElevatedCard(pictureURL)
            Text(
                currentProverb.toString(),
                style = TextStyles.ElevatedCardsTextStyle,
                modifier = rowTextModifier
            )
        }
    }
}

@Composable
fun setPictureOnElevatedCard(pictureURL: String) {
    Image(
        painter = rememberAsyncImagePainter(model = pictureURL),
        contentDescription = "proverbs description",
        modifier = imageModifier,
        contentScale = ContentScale.Crop
    )
}
