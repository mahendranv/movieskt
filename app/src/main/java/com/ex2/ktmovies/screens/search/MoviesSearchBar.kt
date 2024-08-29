package com.ex2.ktmovies.screens.search

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ex2.ktmovies.R
import com.ex2.ktmovies.ui.theme.KtMoviesTheme

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String,
    onSearchClicked: () -> Unit = {},
    onTextChange: (String) -> Unit = {},
) {
    var text by remember { mutableStateOf(TextFieldValue()) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = MaterialTheme.colorScheme.surfaceVariant, shape = RoundedCornerShape(24.dp))
            .padding(vertical = 16.dp, horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            value = text,
            singleLine = true,
            onValueChange = {
                text = it
                onTextChange(it.text)
            },
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = LocalContentColor.current),
            cursorBrush = SolidColor(LocalContentColor.current),
            decorationBox = { innerTextField ->
                if (text.text.isEmpty()) {
                    Text(text = hint, color = LocalContentColor.current.copy(alpha = 0.5f))
                }
                innerTextField()
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text, imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(onSearch = { onSearchClicked() }),
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_search_white_24dp),
            contentDescription = stringResource(id = R.string.search),
            modifier = Modifier.alpha(
                if (text.text.isEmpty()) {
                    0.5f
                } else {
                    1f
                }
            )
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewSearch() {
    KtMoviesTheme {
        Surface {
            SearchBar(hint = "Movie")
        }
    }
}