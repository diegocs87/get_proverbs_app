package com.example.clean_test.presentation.view.ui_compose.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextLabelWithElevatedButton(onButtonClick:() -> Unit, buttonColor:Color, buttonText:String, labelText:String){
    Text(text = labelText, fontWeight = FontWeight.Bold, fontSize = 30.sp)
    Spacer(modifier = Modifier.height(40.dp))
    ElevatedButton(onClick = { onButtonClick() }, colors = ButtonDefaults.buttonColors(containerColor = buttonColor)) {
        Text(buttonText,
            color = Color.White,
            fontFamily = FontFamily.SansSerif)
    }
}