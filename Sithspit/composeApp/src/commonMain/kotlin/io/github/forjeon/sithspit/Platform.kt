package io.github.forjeon.sithspit

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform