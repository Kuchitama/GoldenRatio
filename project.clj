(defproject GoldenRatio "1.0.0-SNAPSHOT"
  :description "File Upload & show sample"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [compojure "1.0.2"]
                 [enlive "1.0.0"]
                 [ring/ring-jetty-adapter "1.1.0-beta3"]
                 [ring/ring-devel "1.1.0-beta3"]]
  :dev-dependencies [[lein-eclipse "1.0.0"]
                     [lein-ring "0.4.5"]]
  :ring {:handler GoldenRatio.core/app}
  :web-content "public")
