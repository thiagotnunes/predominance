# Predominance

Figures out the predominant color in an image.

## Usage

Add this to your leiningen project.clj file:

```clojure
[predominance "0.1.2"]
```

Currently, the following functions are supported.

```clojure
(:require
  [predominance.core :refer :all]
  [clojure.java.io   :as io])
  
; The whole image
(color "/path/to/file.jpg") ; => <#java.awt.Color>

; From a given x
; Starts at the position specified and goes up to the image's width
(color-from-x "/path/to/file.jpg" (starting-pixels 10)) ; => <#java.awt.Color>
; Starts at the position (- width trailing pixels) and goes up to the image's width
(color-from-x "/path/to/file.jpg" (trailing-pixels 10)) ; => <#java.awt.Color>

; From a given y
; Starts at the position specified and goes up to the image's height
(color-from-y "/path/to/file.jpg" (starting-pixels 10)) ; => <#java.awt.Color>
; Starts at the position (- height trailing pixels) and goes up to the image's height
(color-from-y "/path/to/file.jpg" (trailing-pixels 10)) ; => <#java.awt.Color>

; From a given x and y
(color "/path/to/file.jpg" (starting-pixels 0) (starting-pixels 10)) ; => <#java.awt.Color>
(color "/path/to/file.jpg" (trailing-pixels 10) (trailing-pixels 10)) ; => <#java.awt.Color>

; It also accepts files as input
(color (as-file "/path/to/file.jpg")) ; => <#java.awt.Color>
```

## License

(The MIT License)

Copyright (c) 2013 Thiago Tasca Nunes

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the 'Software'), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
