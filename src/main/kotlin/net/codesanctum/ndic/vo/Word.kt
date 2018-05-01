package net.codesanctum.ndic.vo

data class Word(
        val title: String, // 단어 제목
        val number: Int?, // 몇 번째 단어인지
        val url: String, // 영어사전 검색 URL
        val phoneticSymbol: String?, // 발음 기호
        val pronunciation: String?, // 영어 발음 재생 URL
        val meanings: List<Meaning> // 의미
)