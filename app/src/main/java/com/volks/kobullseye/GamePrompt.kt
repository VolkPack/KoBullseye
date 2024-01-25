package com.volks.kobullseye

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GamePrompt(
    modifier: Modifier = Modifier,
    targetValue: Int
){

    /**
     * Instruction Text
     **/
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier

    ){
        Text(
            stringResource(R.string.instruction_text),
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            textAlign = TextAlign.Center,
        )
        /**
         * Target Value
         **/
        /**
         * Target Value
         **/
        Text(

            text = stringResource(R.string.target_value_text, targetValue),
            //text = targetNumber.toString(),
            fontSize = 52.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier.padding(8.dp)
        )
    }
}