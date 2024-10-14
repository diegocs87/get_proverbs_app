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
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.clean_test.R
import com.example.clean_test.domain.entities.Proverbs
import com.example.clean_test.presentation.view.ui_compose.composables.utils.TextStyles
import com.example.clean_test.presentation.viewmodel.ProverbsViewModel


const val PROVERBS_PICTURE_DESCRIPTION = "proverbs description"

private val elevatedCarModifier = Modifier
    .padding(start = 10.dp, end = 10.dp)
    .fillMaxWidth()

private val rowTextModifier = Modifier.fillMaxWidth(0.8f)

private val imageModifier = Modifier
    .size(80.dp)
    .padding(start = 3.dp, end = 3.dp)
    .height(intrinsicSize = IntrinsicSize.Max)

private val iconModifier = Modifier
    .fillMaxSize()
    .padding(start = 5.dp, end = 5.dp, bottom = 2.dp, top = 2.dp)

@Composable
fun SetElevatedCardWith(
    currentProverb: Proverbs, pictureURL: String, page: Int
) {
    ElevatedCard(modifier = elevatedCarModifier) {
        Row {
            SetPictureOnElevatedCard(pictureURL)
            Text(
                currentProverb.toString(),
                style = TextStyles.ElevatedCardsTextStyle,
                modifier = rowTextModifier.align(Alignment.CenterVertically)
            )

            when (page) {
                0 -> SetFavoritesLogo(
                    iconModifier.align(Alignment.CenterVertically), currentProverb
                )

                1 -> SetRemoveLogo(
                    iconModifier.align(Alignment.CenterVertically), currentProverb
                )
            }
        }
    }
}

@Composable
fun SetPictureOnElevatedCard(pictureURL: String) {
    Image(
        painter = rememberAsyncImagePainter(model = pictureURL),
        contentDescription = PROVERBS_PICTURE_DESCRIPTION,
        modifier = imageModifier,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun SetFavoritesLogo(modifier: Modifier, currentProverb: Proverbs) {
    val proverbsViewModel: ProverbsViewModel = hiltViewModel()
    var isToggled by remember { mutableStateOf(false) }
    IconButton(onClick = {
        isToggled = !isToggled
        setFavoriteState(isToggled, proverbsViewModel, currentProverb)
    }, modifier = modifier) {
        val icon = getPainterIf(isToggled)
        Image(
            painter = icon,
            contentDescription = PROVERBS_PICTURE_DESCRIPTION,
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun SetRemoveLogo(modifier: Modifier, currentProverb: Proverbs) {
    val proverbsViewModel: ProverbsViewModel = hiltViewModel()
    IconButton(
        onClick = { removeFavorite(proverbsViewModel, currentProverb) }, modifier = modifier
    ) {
        val icon = painterResource(R.drawable.trash_icon)
        Image(
            painter = icon,
            contentDescription = PROVERBS_PICTURE_DESCRIPTION,
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun getPainterIf(isToggled: Boolean): Painter {
    val icon = if (isToggled) {
        painterResource(id = R.drawable.favorite_logo_clicked)
    } else {
        painterResource(id = R.drawable.favorite_logo_no_clicked)
    }
    return icon
}

private fun removeFavorite(proverbsViewModel: ProverbsViewModel, currentProverb: Proverbs) {
    proverbsViewModel.removeFavorite(currentProverb)
}


private fun setFavoriteState(
    isToggled: Boolean, proverbsViewModel: ProverbsViewModel, currentProverb: Proverbs
) = if (isToggled) {
    proverbsViewModel.addFavorite(currentProverb)
} else {
    proverbsViewModel.removeFavorite(currentProverb)
}