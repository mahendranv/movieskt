package com.ex2.ktmovies.screens.details

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ex2.ktmovies.data.fake.FakeData
import com.ex2.ktmovies.domain.model.DCast
import com.ex2.ktmovies.ui.theme.KtMoviesTheme
import com.ex2.ktmovies.ui.widgets.PersonCard

@Composable
fun CastListUi(
    modifier: Modifier = Modifier,
    list: List<DCast>,
    contentPadding: Dp
) {
    LazyRow(
        modifier,
        contentPadding = PaddingValues(contentPadding),
        horizontalArrangement = Arrangement.Absolute.spacedBy(16.dp)
    ) {
        items(list, key = { it.id }) {
            PersonCard(cast = it, modifier = Modifier.width(150.dp))
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_6)
@Composable
private fun previewCastList() {
    KtMoviesTheme {
        Surface {
            CastListUi(list = FakeData.castList, contentPadding = 24.dp)
        }
    }
}