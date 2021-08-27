package com.ex2.ktmovies.common

open class Failure {

    protected var message: String = ""

    protected var code: Int = 0

    companion object {

        val UNKNOWN = Failure().apply {
            message = "Unknown error"
            code = -1
        }

        // TODO: Define network errors
    }
}