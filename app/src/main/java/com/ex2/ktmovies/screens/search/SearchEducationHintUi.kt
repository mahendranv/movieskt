package com.ex2.ktmovies.screens.search

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ex2.ktmovies.R
import com.ex2.ktmovies.ui.theme.KtMoviesTheme


@Composable
fun SearchEducationHintUi(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(top = 160.dp)
                .align(Alignment.TopCenter)
                .alpha(0.7f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_search_white_24dp),
                contentDescription = "Search",
                modifier = Modifier
                    .size(100.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
            )
            Text(
                text = "Search by Movie name, Genre",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Preview(device = Devices.PIXEL_6)
@Preview(device = Devices.PIXEL_6, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewSearchEducationUi() {
    KtMoviesTheme {
        Surface {
            SearchEducationHintUi()
        }
    }
}