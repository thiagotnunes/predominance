(defproject predominance "0.1.2"
  :description "Figures out the predominant colors in an image"
  :url "http://github.com/thiagotnunes/predominance"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  
  :dependencies [[org.clojure/clojure "1.5.1"]]

  :profiles {:production {:env {:production true}}
             :dev {:dependencies [[midje "1.5.1"]]
                   :plugins      [[lein-midje "3.0.0"]
                                  [lein-kibit "0.0.8"]
                                  [lein-cloverage "1.0.2"]]}})
