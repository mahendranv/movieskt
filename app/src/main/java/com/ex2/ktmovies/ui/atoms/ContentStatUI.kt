package com.ex2.ktmovies.ui.atoms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun LoadingProgress(modifier: Modifier = Modifier.fillMaxSize()) {
    Box(modifier) {
        LinearProgressIndicator(
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun FullScreenText(
    modifier: Modifier = Modifier.fillMaxSize(),
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    text: String
) {
    Box(modifier) {
        Text(
            text = text,
            style = style,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}