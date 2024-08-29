package com.ex2.ktmovies.nav

interface IDestination {

    val route: String

    val routeTemplate: String
        get() = ""
}