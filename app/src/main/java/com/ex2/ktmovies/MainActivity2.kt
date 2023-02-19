package com.ex2.ktmovies

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ex2.ktmovies.presentation.common.BottomAppBar
import com.ex2.ktmovies.presentation.common.defaultBottomBarSelection
import com.ex2.ktmovies.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppHost()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieAppHost(modifier: Modifier = Modifier) {
    var selectedTab by remember {
        mutableStateOf(defaultBottomBarSelection)
    }

    AppTheme {
        Scaffold(modifier = modifier,
            bottomBar = {
                BottomAppBar(
                    selectedId = selectedTab,
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.surfaceVariant)
                        .fillMaxWidth()
                ) {
                    selectedTab = it
                }
            }
        ) { padding ->
            Text("Hello Compose KT", modifier = Modifier.padding(padding))
        }
    }
}