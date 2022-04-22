package com.example.authentication.util

class GoogleAccountNotFoundException(
    override val message: String? = "Google Account Not Found"
): Exception() {
}