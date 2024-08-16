package com.ex2.ktmovies.domain.usecase.base

import com.ex2.ktmovies.common.Either
import com.ex2.ktmovies.common.Failure
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(
        params: Params,
        scope: CoroutineScope = GlobalScope,
        onResult: (Either<Failure, Type>) -> Unit = {}
    ) = scope.launch(Dispatchers.Main) {
        val deferred = async(Dispatchers.IO) {
            run(params)
        }
        onResult(deferred.await())
    }
    class None
}