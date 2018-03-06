NDic (Naver English/Korean Dictionary) &middot; [![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/WickeDev/ndic/blob/master/LICENSE) [![Download](https://api.bintray.com/packages/wickedev/maven/ndic-jvm/images/download.svg)](https://bintray.com/wickedev/maven/ndic-jvm/_latestVersion) 
===============================================

Naver English-Korean dictionary Kotlin(Java compatible) Library

Download &middot; [![Download](https://api.bintray.com/packages/wickedev/maven/ndic-jvm/images/download.svg)](https://bintray.com/wickedev/maven/ndic-jvm/_latestVersion)
--------

Gradle:
```groovy
repositories { jcenter() }
compile 'net.codesanctum:ndic-jvm:x.y.z'
``` 

Examples
--------

Kotlin
```kotlin
val words = NDic.search("test") // blocking call, DO NOT USE IN MAIN THREAD!
```

Java
```
List<Word> words = NDic.search("test"); // blocking call, DO NOT USE IN MAIN THREAD!
```
Result
```kotlin
data class Word(
        val title: String, // 단어 제목
        val number: Int?, // 몇 번째 단어인지
        val url: String, // 영어사전 검색 URL
        val phoneticSymbol: String?, // 발음 기호
        val pronunciation: String?, // 영어 발음 재생 URL
        val meanings: List<Meaning> // 의미
)

data class Meaning(
        val type: String?, // 품사의 종류
        val definitions: List<Definition>, // 의미
        val moreDefinition: MoreDefinition? // 더보기 정보
)

data class Definition(
        val def: String, // 의미
        val exEn: String?, // 영어 예문
        val exKr: String? // 국어 예문
)

data class MoreDefinition(
        val count: Int, // 더보기 개수
        val url: String // 더보기 URL
)
```

License
=======

    The MIT License
    
    Copyright (c) 2018 Ryan Yang, http://codesanctum.net
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.