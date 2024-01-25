package com.volks.kobullseye

import android.graphics.drawable.GradientDrawable.Orientation
import android.provider.CalendarContract.Colors
import android.text.Layout
import android.util.Log
import android.view.View
import android.widget.TextView
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.volks.kobullseye.ui.theme.KoBullseyeTheme
import org.w3c.dom.Text
import kotlin.random.Random

//TEST
@Composable
fun GameScreen() {
    var number = GenerateRandomNumber()
    var alertIsVisible by rememberSaveable { mutableStateOf(false) }
    var sliderValue by rememberSaveable { mutableStateOf(0.5f) }
    var num by remember { mutableStateOf(Random.nextInt(100)) }
    val sliderToInt = (sliderValue *100).toInt()

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

            GamePrompt(targetNumber = num)
            TargetSlider(
                value = sliderValue,
                valueChanged = {value ->
                    sliderValue = value
                }
            )
            Button(onClick = {
                alertIsVisible = true
                Log.i("Alert Visible?", alertIsVisible.toString())
                Log.i("Current Number", num.toString())
            }
            ) {
                Text(
                    text = stringResource(R.string.hit_me_button_text),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )

            }
        }
        Spacer(modifier = Modifier.weight(0.5f))

        if (alertIsVisible) {
            ResultDialog(
                hideDialog = {alertIsVisible=false},
                sliderValue = sliderToInt
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    KoBullseyeTheme {
        GameScreen()
    }
}

fun GenerateRandomNumber(): Int {
    var num: Int = Random.nextInt(100)
    return num
}