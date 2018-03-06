NDic (Naver English/Korean Dictionary) &middot; [![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/WickeDev/ndic/blob/master/LICENSE) [![Download](https://api.bintray.com/packages/wickedev/maven/ndic-jvm/images/download.svg)](https://bintray.com/wickedev/maven/ndic-jvm/_latestVersion) 
====

Naver English-Korean dictionary Kotlin(Java compatible) Library

Download
--------

Gradle:
```groovy
maven { url 'https://dl.bintray.com/wickedev/maven/' }
compile 'net.codesanctum:ndic-jvm:0.1.0'
``` 

Download
--------

Kotlin
```kotlin
val words = NDic.search("test") // blocking call
```

Java
```
List<Word> words = NDic.search("test"); // blocking call
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