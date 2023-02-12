package com.ex2.ktmovies

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            MovieAppHost()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieAppHost(modifier: Modifier = Modifier) {
    MaterialTheme {
        Scaffold(modifier = modifier) { padding ->
            Text("Hello Compose KT", modifier = Modifier.padding(padding))
        }
    }
}