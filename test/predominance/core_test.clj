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
       (fact "finds black when the image is all black"
             (hex-string (predominant/color "resources/blackWhiteGray5pxGray.jpg" 15)) => "aaaaaa"))
