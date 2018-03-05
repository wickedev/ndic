package net.codesanctum.ndic.vo

data class Meaning(
        val type: String?, // 품사의 종류
        val definitions: List<Definition>, // 의미
        val moreDefinition: MoreDefinition? // 더보기 정보
)