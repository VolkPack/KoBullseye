package com.volks.kobullseye.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volks.kobullseye.R

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
            style = MaterialTheme.typography.titleMedium.copy(letterSpacing = 1.sp, fontWeight = FontWeight.Bold)
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
//            fontSize = 52.sp,
//            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GamePromptPreview() {
    GamePrompt(targetValue = 50)
}