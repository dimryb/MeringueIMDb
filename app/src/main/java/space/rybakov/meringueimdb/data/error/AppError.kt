package space.rybakov.meringueimdb.data.error

import java.lang.RuntimeException

sealed class AppError(val code: String): RuntimeException()

class ApiError(val status: Int, code: String): AppError(code)
object NetworkError : AppError("error_network")
object UnknownError: AppError("error_unknown")
