package com.ex2.ktmovies.screens.search

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.ex2.ktmovies.R
import com.ex2.ktmovies.data.fake.FakeData
import com.ex2.ktmovies.domain.model.MovieResult
import com.ex2.ktmovies.prepareMeta
import com.ex2.ktmovies.ratingText
import com.ex2.ktmovies.ui.atoms.RemoteImage
import com.ex2.ktmovies.ui.theme.KtMoviesTheme
import com.ex2.ktmovies.ui.widgets.TextWithIcon

@Preview(showSystemUi = true, device = Devices.NEXUS_6)
//@Preview(showSystemUi = true, device = Devices.NEXUS_6, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewSearchListItem() {
    KtMoviesTheme {
        Surface {
            SearchListItem(result = FakeData.searchResults[7])
        }
    }
}

@Composable
fun SearchListItem(
    modifier: Modifier = Modifier, result: MovieResult
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
//            .border(1.dp, color = Color.Red)
    ) {
        val (thumb, title, rating, meta, description) = createRefs()
        val sideAnchor = createGuidelineFromStart(0.35f)

        RemoteImage(url = result.imageUrl, modifier = Modifier.constrainAs(thumb) {
            top.linkTo(parent.top, margin = 8.dp)
            start.linkTo(parent.start, margin = 16.dp)
            end.linkTo(sideAnchor, margin = 16.dp)
            bottom.linkTo(rating.top, margin = 4.dp)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })

        Text(text = result.title,
            minLines = 1,
            maxLines = 2,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(thumb.top)
                end.linkTo(parent.end, margin = 16.dp)
                start.linkTo(sideAnchor)
                width = Dimension.fillToConstraints
            })

        Text(text = result.prepareMeta(),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.constrainAs(meta) {
                top.linkTo(title.bottom, margin = 4.dp)
                start.linkTo(title.start)
                end.linkTo(title.end)
                width = Dimension.fillToConstraints
            })

        Text(text = result.overview,
            minLines = 5,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.constrainAs(description) {
                top.linkTo(meta.bottom, margin = 4.dp)
                start.linkTo(title.start)
                end.linkTo(title.end)
                bottom.linkTo(parent.bottom, margin = 8.dp)
                width = Dimension.fillToConstraints
            })

        TextWithIcon(text = result.ratingText(),
            iconResId = R.drawable.ic_rating_star,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.constrainAs(rating) {
                start.linkTo(thumb.start)
                bottom.linkTo(description.bottom)
            })
    }
}
