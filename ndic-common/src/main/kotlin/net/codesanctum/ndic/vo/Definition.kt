package net.codesanctum.ndic.vo

data class Definition(
        val def: String, // 의미
        val exEn: String?, // 영어 예문
        val exKr: String? // 국어 예문
)