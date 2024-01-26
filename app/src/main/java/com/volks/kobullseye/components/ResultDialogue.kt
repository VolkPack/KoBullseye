package com.volks.kobullseye.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.volks.kobullseye.R

@Composable
fun ResultDialog(
    dialogTitle: Int,
    hideDialog: () -> Unit,
    onRoundIncriment: () -> Unit,
    sliderValue: Int,
    points: Int,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        onDismissRequest = {
            hideDialog()
            onRoundIncriment()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    hideDialog()
                    onRoundIncriment()
                }
            ) {
                Text(stringResource(id = R.string.result_dialog_button_text))
            }
        },
        title = { Text(stringResource(id = dialogTitle)) },
        text = { Text(stringResource(id = R.string.result_dialog_message, sliderValue, points )) }
       //text = { Text(text = "Slider Value is $sliderValue")}
    )
}