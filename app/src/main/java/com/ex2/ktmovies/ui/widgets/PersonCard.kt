package com.ex2.ktmovies.ui.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ex2.ktmovies.data.fake.FakeData
import com.ex2.ktmovies.domain.model.DCast
import com.ex2.ktmovies.ui.atoms.RemoteImage
import com.ex2.ktmovies.ui.theme.KtMoviesTheme

@Composable
fun PersonCard(modifier: Modifier = Modifier, cast: DCast) {
    Column(modifier.clip(RoundedCornerShape(8.dp))) {
        RemoteImage(
            url = cast.url, modifier = Modifier.aspectRatio(0.7f)
        )
        Text(
            text = cast.name,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp, top = 8.dp)
        )
        Text(
            text = cast.character,
            style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic),
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
private fun PreviewPersonCard() {
    KtMoviesTheme {
        Surface {
            PersonCard(cast = FakeData.castList[0])
        }
    }
}