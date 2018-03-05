package net.codesanctum.ndic.vo

data class Word(
        val title: String,
        val number: Int?,
        val url: String,
        val phoneticSymbol: String?,
        val pronunciation: String?,
        val meanings: List<Meaning>
)