package com.volks.kobullseye.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.volks.kobullseye.R

@Composable
fun GameDetail(
    totalScore: Int = 0,
    onStartOver: () -> Unit,
    round: Int = 1,
    modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier=modifier) {
        //Restart
        Button(onClick = {onStartOver() }) {
            Text(text = stringResource(R.string.start_over) )
        }
        //Score Widget
        GameInfo(label = stringResource(id = R.string.score_label), value = totalScore)
        //Round Widget
        GameInfo(label = stringResource(id = R.string.current_round_label), value = round)
        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(R.string.info) )
        }

    }
}

@Composable
fun GameInfo(label: String, value: Int = 0) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 32.dp)
    ) {
        Text(label)
        Text(value.toString())

    }
}

@Preview(showBackground = true)
@Composable
fun GameDetailPreview(){
    GameDetail(onStartOver = {})
}