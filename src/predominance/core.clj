(ns predominance.core
  (:require
   [clojure.java.io     :as io]
   [slingshot.slingshot :refer [throw+]])
  (:import
   [java.awt.image BufferedImage]
   [java.awt Color]
   [java.util Collections Comparator HashMap Iterator LinkedList List Map]
   [javax.imageio ImageIO ImageReader]
   [javax.imageio.stream ImageInputStream]))

(defn- image-reader-from [filename]
  (let [file (io/as-file filename)
        image-stream (ImageIO/createImageInputStream file)
        image-readers (ImageIO/getImageReaders image-stream)]
    (if (.hasNext image-readers)
      (doto (.next image-readers) (.setInput image-stream))
      (throw+ {:type ::image-error}))))

(defn- image-data-from [image-reader]
  (let [image (.read image-reader 0)]
    {:image image
     :width (.getWidth image)
     :height (.getHeight image)}))

(defn- count-colors [{image :image width :width height :height} x y]
  (let [colors (atom {})]
    (doseq [i (range x width)
            j (range y height)]
      (let [rgb (.getRGB image i j)
            color-count (@colors rgb)]
        (if color-count
          (swap! colors assoc rgb (+ 1 color-count))
          (swap! colors assoc rgb 1))))
    @colors))

(defn- ->Color [[rgb _]]
  (Color. rgb))

(defn- predominant-color [filename x-fn y-fn]
  (let [image-reader (image-reader-from filename)
        image-data (image-data-from image-reader)
        color-count (count-colors image-data
                                  (x-fn image-data)
                                  (y-fn image-data))]
    (->> color-count
         (sort-by second)
         reverse
         first
         ->Color)))

(defn hex-string [color]
  (subs (Integer/toHexString (.getRGB color)) 2))

(defn starting-pixels [from]
  (fn [_]
    from))

(defn trailing-pixels [from]
  (fn [dim]
    (- dim from)))

(defn color [filename]
  (predominant-color filename
                     (starting-pixels 0)
                     (starting-pixels 0)))

(defn color-from-x [filename x-fn]
  (predominant-color filename
                     (fn [{width :width}] (x-fn width))
                     (starting-pixels 0)))

(defn color-from-y [filename y-fn]
  (predominant-color filename
                     (starting-pixels 0)
                     (fn [{height :height}] (y-fn height))))
