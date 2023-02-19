package com.ex2.ktmovies.presentation.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ex2.ktmovies.presentation.icons.AppIcons
import com.ex2.ktmovies.presentation.icons.appicons.Bookmark
import com.ex2.ktmovies.presentation.icons.appicons.Home
import com.ex2.ktmovies.presentation.icons.appicons.Search
import com.ex2.ktmovies.presentation.theme.AppTheme

data class BottomBarItemConfiguration(
    val id: String,
    val icon: ImageVector,
    val label: String
)

val bottomBarItems = listOf(
    BottomBarItemConfiguration(id = "home", icon = AppIcons.Home, label = "Home"),
    BottomBarItemConfiguration(id = "explore", icon = AppIcons.Search, label = "Explore"),
    BottomBarItemConfiguration(id = "saved", icon = AppIcons.Bookmark, label = "Saved"),
)

val defaultBottomBarSelection = bottomBarItems.first().id

@Composable
fun BottomAppBar(
    modifier: Modifier = Modifier,
    selectedId: String = "home",
    items: List<BottomBarItemConfiguration> = bottomBarItems,
    itemSelected: (String) -> Unit
) {
    Row(
        modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        for (i in items) {
            BottomBarItem(
                selected = i.id == selectedId,
                config = i,
                modifier = Modifier.clickable {
                    itemSelected(i.id)
                })
        }
    }
}

@Composable
fun BottomBarItem(
    selected: Boolean,
    config: BottomBarItemConfiguration,
    modifier: Modifier = Modifier
) {
    val color =
        if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface

//    val animatedColor by animateColorAsState(targetValue = color)

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = config.icon,
            tint = color,
            modifier = Modifier
                .padding(8.dp)
                .size(24.dp),
            contentDescription = config.label
        )

        AnimatedVisibility(visible = selected) {
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = config.label,
                color = color,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview
@Composable
fun PreviewBottomBar() {

    var selectedId by remember {
        mutableStateOf(defaultBottomBarSelection)
    }

    AppTheme {
        Surface {
            BottomAppBar(
                selectedId = selectedId,
                modifier = Modifier.fillMaxWidth()
            ) {
                selectedId = it
            }
        }
    }
}