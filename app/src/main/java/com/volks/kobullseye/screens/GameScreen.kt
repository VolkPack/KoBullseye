package com.volks.kobullseye.screens

/**
 * TODO LIST COURSE 2
 * - Implement Multiple Rounds
 * - Implement Restart the Game
 * - Implement Background and images - Make it Pretty
 * - Add the About Screen
 */

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.volks.kobullseye.R
import com.volks.kobullseye.components.GameDetail
import com.volks.kobullseye.components.GamePrompt
import com.volks.kobullseye.components.ResultDialog
import com.volks.kobullseye.components.TargetSlider
import com.volks.kobullseye.ui.theme.KoBullseyeTheme
import java.lang.Math.abs
import kotlin.random.Random

//TEST
@Composable
fun GameScreen() {
    fun newTargetValue() = Random.nextInt(1, 100)

    var alertIsVisible by rememberSaveable { mutableStateOf(false) }
    var sliderValue by rememberSaveable { mutableStateOf(0.5f) }
    var targetValue by rememberSaveable { mutableStateOf(newTargetValue()) }
    val sliderToInt = (sliderValue * 100).toInt()
    var totalScore by rememberSaveable { mutableStateOf(0)}
    var currentRound by rememberSaveable { mutableStateOf(1)}

    fun differenceAmmount() = abs(targetValue - sliderToInt)


    fun pointsForCurrentRound(): Int{
        val maxScore = 100
        val difference = differenceAmmount()
        var bonus = 0
        if (difference == 0) {
            bonus = 100
        } else if (difference == 1) {
            bonus = 50
        }
        return (maxScore - difference) + bonus
    }

    fun startNewGame(){
        totalScore = 0
        currentRound = 1
        sliderValue = 0.5f
        targetValue = newTargetValue()
    }

    fun alertTitle(): Int{

        val title: Int = when {
            differenceAmmount() == 0 -> {
                R.string.alert_title_1
            }
            differenceAmmount() < 5 -> {
                R.string.alert_title_2
            }
            differenceAmmount() <= 10 -> {
                R.string.alert_title_3
            }
            else -> {
                R.string.alert_title_4
            }
        }
        return title
    }


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

            GamePrompt(targetValue = targetValue)
            TargetSlider(
                value = sliderValue,
                valueChanged = { value ->
                    sliderValue = value
                }
            )
            /**
             * HitMe Button
             */
            Button(onClick = {
                alertIsVisible = true
                totalScore += pointsForCurrentRound()
                Log.i("Alert Visible?", alertIsVisible.toString())
                Log.i("Current Number", targetValue.toString())
            }) {
                Text(
                    text = stringResource(R.string.hit_me_button_text),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
            }
            GameDetail(
                totalScore = totalScore,
                round = currentRound,
                modifier = Modifier.fillMaxWidth(),
                onStartOver = {startNewGame()}
                )

        }
        Spacer(modifier = Modifier.weight(0.5f))

        if (alertIsVisible) {
            ResultDialog(
                dialogTitle = alertTitle(),
                hideDialog = { alertIsVisible = false },
                sliderValue = sliderToInt,
                points = pointsForCurrentRound(),
                onRoundIncriment = {
                    currentRound += 1
                    targetValue =  newTargetValue()
                }
            )

        }
    }

}


@Preview(showBackground = true, device = Devices.AUTOMOTIVE_1024p, widthDp = 864, heightDp = 432)@Composable
fun GameScreenPreview() {
    KoBullseyeTheme {
        GameScreen()
    }
}

/**
 * Random Int Number Generator
 */
fun GenerateRandomNumber(): Int {
    val num: Int = Random.nextInt(100)
    return num
}

