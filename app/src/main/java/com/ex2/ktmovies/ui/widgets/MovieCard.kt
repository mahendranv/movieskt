package com.ex2.ktmovies.ui.widgets

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.ex2.ktmovies.R
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.ui.atoms.RemoteImage
import com.ex2.ktmovies.ui.atoms.gradientBackground
import com.ex2.ktmovies.ui.theme.KtMoviesTheme
import java.util.Locale

@Composable
fun MovieCard2(modifier: Modifier = Modifier, movie: MovieLite) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(0.6f)
//            .border(width = 0.5.dp, MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(12.dp))
    ) {
        ConstraintLayout {
            val (image, rating, title) = createRefs()
            RemoteImage(
                url = movie.imageUrl,
                modifier = Modifier
                    .constrainAs(ref = image) {
                        bottom.linkTo(title.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
            )

            Text(
                text = movie.title,
                textAlign =  TextAlign.Start,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(title) {
                        top.linkTo(image.bottom, margin = 6.dp)
                        bottom.linkTo(parent.bottom, margin = 8.dp)
                        start.linkTo(parent.start, margin = 4.dp)
                    },
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp)
            )

            TextWithIcon(text = String.format(Locale.getDefault(), "%.1f", movie.rating),
                iconResId = R.drawable.ic_rating_star,
                style = MaterialTheme.typography.bodyMedium,
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier
                    .alpha(0.6f)
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(4.dp)
                    .constrainAs(rating) {
                        top.linkTo(parent.top, margin = 8.dp)
                        end.linkTo(parent.end, margin = 8.dp)
                    })
        }
    }
}

@Preview(device = Devices.NEXUS_6, showBackground = true)
@Preview(device = Devices.NEXUS_6, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun MovieCardPreview() {
    KtMoviesTheme {
        MovieCard2(
            movie = MovieLite(
                id = "no", title = "Batman", rating = 4.5, imageUrl = null
            )
        )
    }
}

@Composable
fun TextWithIcon(
    text: String,
    @DrawableRes iconResId: Int,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    tint: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    iconSize: Dp = 18.dp
) {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            modifier = Modifier.size(iconSize),
            tint = tint // Apply the tint passed as an argument
        )
        Spacer(modifier = Modifier.width(4.dp)) // Optional: Add some space between icon and text
        Text(text = text, style = style, color = tint)
    }
}
