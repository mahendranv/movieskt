package com.ex2.ktmovies.presentation.icons

import androidx.compose.ui.graphics.vector.ImageVector
import com.ex2.ktmovies.presentation.icons.appicons.Arrowleft
import com.ex2.ktmovies.presentation.icons.appicons.Arrowright
import com.ex2.ktmovies.presentation.icons.appicons.Bookmark
import com.ex2.ktmovies.presentation.icons.appicons.Bookmarkfilled
import com.ex2.ktmovies.presentation.icons.appicons.Cast
import com.ex2.ktmovies.presentation.icons.appicons.Clockfive
import com.ex2.ktmovies.presentation.icons.appicons.Gallery
import com.ex2.ktmovies.presentation.icons.appicons.Home
import com.ex2.ktmovies.presentation.icons.appicons.Popcorn
import com.ex2.ktmovies.presentation.icons.appicons.Search
import com.ex2.ktmovies.presentation.icons.appicons.Star
import com.ex2.ktmovies.presentation.icons.appicons.Starfillled
import com.ex2.ktmovies.presentation.icons.appicons.Trending
import kotlin.collections.List as ____KtList

public object AppIcons

private var __AllIcons: ____KtList<ImageVector>? = null

public val AppIcons.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(Arrowleft, Arrowright, Bookmark, Bookmarkfilled, Cast, Clockfive, Gallery,
        Home, Popcorn, Search, Star, Starfillled, Trending)
    return __AllIcons!!
  }
