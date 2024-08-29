package com.ex2.ktmovies.screens.details

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ex2.ktmovies.R
import com.ex2.ktmovies.data.fake.FakeData
import com.ex2.ktmovies.domain.model.MovieDetails
import com.ex2.ktmovies.prepareMeta
import com.ex2.ktmovies.ratingText
import com.ex2.ktmovies.ui.atoms.RemoteImage
import com.ex2.ktmovies.ui.theme.KtMoviesTheme
import com.ex2.ktmovies.ui.widgets.TextWithIcon

@Composable
fun DetailsScreenUi(
    modifier: Modifier = Modifier, details: MovieDetails,
    relatedMovieClicked: (String) -> Unit = {}
) {
    Surface {
        Column(modifier = modifier.verticalScroll(rememberScrollState())) {
            RemoteImage(
                url = details.covers.first(), modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.54f)
            )
            Text(
                text = details.title,
                modifier = Modifier.padding(start = 24.dp, top = 24.dp),
                style = MaterialTheme.typography.headlineSmall
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .padding(horizontal = 24.dp)
                    .border(0.5.dp, MaterialTheme.colorScheme.tertiary, shape = RoundedCornerShape(12.dp))
                    .padding(horizontal = 16.dp, vertical = 16.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = details.prepareMeta())
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .width(0.dp)
                )
                TextWithIcon(
                    text = details.ratingText(),
                    iconResId = R.drawable.ic_rating_star,
                    modifier = Modifier.padding(start = 24.dp)
                )
            }

            Text(
                text = details.summary, modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 16.dp)
            )

            if (details.related.isNotEmpty()) {
                Text(
                    text = "Related",
                    modifier = Modifier.padding(start = 24.dp, top = 24.dp),
                    style = MaterialTheme.typography.headlineSmall
                )

                RelatedMoviesUi(
                    movies = details.related,
                    contentPadding = 24.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                ) { id ->
                    relatedMovieClicked(id)
                }
            }
        }
    }
}

@Preview(device = Devices.PIXEL_6, showSystemUi = true)
@Preview(device = Devices.PIXEL_6, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewDetailsScreen() {
    KtMoviesTheme {
        DetailsScreenUi(details = FakeData.movieDetail)
    }
}