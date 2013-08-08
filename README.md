# Predominance

Figures out the predominant color in an image.

## Usage

Add this to your leiningen project.clj file:

```clojure
[predominance "0.1.0"]
```

Currently, the following functions are supported.

```clojure
(:require
  [predominance.core :as predominant]
  [clojure.java.io   :as io])
  
; The whole image
(predominant/color "/path/to/file.jpg") ; => <#java.awt.Color "#FFF">

; From a given x
(predominant/color-from-x "/path/to/file.jpg" 300) ; => <#java.awt.Color "#EEE">

; From a given y
(predominant/color-from-y "/path/to/file.jpg" 200) ; => <#java.awt.Color "#DDD">

; It also accepts files as input
(predominant/color (as-file "/path/to/file.jpg")) ; => <#java.awt.Color "#FFF">
```

## License

(The MIT License)

Copyright (c) 2013 Thiago Tasca Nunes

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the 'Software'), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
