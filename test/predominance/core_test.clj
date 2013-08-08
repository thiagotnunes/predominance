(ns predominance.core-test
  (:require
   [midje.sweet       :refer :all]
   [predominance.core :as predominant]))

(defn hex-string [color]
  (subs (Integer/toHexString (.getRGB color)) 2))

(facts "about finding predominant color on the whole image"
       (fact "finds black when the image is all black"
             (hex-string (predominant/color "resources/black.jpg")) => "000000")

       (fact "finds black when the image has more black"
             (hex-string (predominant/color "resources/blackWhiteMoreBlack.jpg")) => "000000"))

(facts "about finding predominant color from a given x"
       (fact "finds the predominant color from the given x"
             (hex-string (predominant/color-from-x "resources/grayFrom15X.jpg" 15)) => "aaaaaa"))

(facts "about finding predominant color from a given y"
       (fact "finds the predominant color from the given y"
             (hex-string (predominant/color-from-y "resources/grayFrom15Y.jpg" 15)) => "aaaaaa"))
