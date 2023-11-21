package com.volks.kobullseye

import android.graphics.drawable.GradientDrawable.Orientation
import android.provider.CalendarContract.Colors
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volks.kobullseye.ui.theme.KoBullseyeTheme
//TEST
@Composable
fun GameScreen(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.weight(0.5f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.weight(9f)
        ) {
            Text(
                stringResource(R.string.instruction_text),
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                textAlign = TextAlign.Center,
                )
            Text(text = stringResource(R.string.target_value_text), fontSize = 52.sp, fontWeight = FontWeight.Bold, color = Color.Red)

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.min_slider_value),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 16.dp)
                    )
                Slider(
                    value = 0.5f,
                    valueRange = 0.01f..1f,
                    onValueChange = {},
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = stringResource(R.string.max_slider_value),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(end = 16.dp)
                    )
            }
            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(R.string.hit_me_button_text),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )

            }
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }

}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    KoBullseyeTheme {
        GameScreen()
    }
}