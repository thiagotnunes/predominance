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

(defn- predominant-color [coll]
  (first coll))

(defn- ->Color [[rgb _]]
  (Color. rgb))

(defn color
  ([filename x y]
     (let [image-reader (image-reader-from filename)
           image-data (image-data-from image-reader)
           color-count (count-colors image-data x y)]
       (->> color-count
            (sort-by second)
            reverse
            predominant-color
            ->Color)))
  ([filename]
     (color filename 0 0)))

(defn color-from-x [filename x]
  (color filename x 0))

(defn color-from-y [filename y]
  (color filename 0 y))
