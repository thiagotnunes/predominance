(ns predominance.core-test
  (:require
   [midje.sweet       :refer :all]
   [predominance.core :refer :all]
   [clojure.java.io   :as io]))

(defn hex-string [color]
  (subs (Integer/toHexString (.getRGB color)) 2))

(facts "about finding predominant color on the whole image"
       (fact "finds black when the image is all black"
             (hex-string (color "resources/black.jpg")) => "000000")

       (fact "finds black when the image has more black"
             (hex-string (color "resources/blackWhiteMoreBlack.jpg")) => "000000"))

(facts "about finding predominant color from a given x"
       (fact "finds the predominant color from the start position "
             (hex-string (color-from-x "resources/grayFrom15X.jpg"
                                       (starting-pixels 15))) => "aaaaaa")

       (fact "finds the predominant color from the trailing position "
             (hex-string (color-from-x "resources/grayFrom15X.jpg"
                                       (trailing-pixels 5))) => "aaaaaa"))

(facts "about finding predominant color from a given y"
       (fact "finds the predominant color from the start position"
             (hex-string (color-from-y "resources/grayFrom15Y.jpg"
                                       (starting-pixels 15))) => "aaaaaa")

       (fact "finds the predominant color from the trailing position "
             (hex-string (color-from-y "resources/grayFrom15Y.jpg"
                                       (trailing-pixels 5))) => "aaaaaa"))

(fact "accepts files as input"
      (hex-string (color (io/as-file "resources/black.jpg"))) => "000000")
