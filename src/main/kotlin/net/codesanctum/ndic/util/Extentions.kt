package net.codesanctum.ndic.util


fun String.emptyToNull(): String? = if (this == "") null else this

fun String.toNullOrInt(): Int? = if (isEmpty()) null else toInt()