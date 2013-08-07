# Predominance

Figures out the predominant color in an image.

## Usage

```
(:require
  [predominance.core :as predominant])
  
(predominant/color "/path/to/file.jpg") ; => <#java.awt.Color "#FFF">

; From a given width and height
(predominant/color "/path/to/file.jpg" 300 400) ; => <#java.awt.Color "#EEE">
```

## License

Copyright © 2013 FIXME

Distributed under the Eclipse Public License, the same as Clojure.
