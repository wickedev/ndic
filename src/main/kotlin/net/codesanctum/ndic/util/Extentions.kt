package net.codesanctum.ndic.util


fun String.emptyToNull(): String? = if (isNullOrEmpty()) null else this

fun String.toNullOrInt(): Int? = if (isNullOrEmpty()) null else toInt()