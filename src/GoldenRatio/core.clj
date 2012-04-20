(ns GoldenRatio.core
  (:use [net.cgrand.enlive-html
         :only [deftemplate defsnippet content html-content clone-for nth-of-type first-child do-> set-attr sniptest at emit*]]
        [compojure.core]
        [ring.adapter.jetty])
  (:require (compojure [route :as route])
            (compojure [handler :as handler])
            (ring.util [response :as response])
            (ring.middleware [multipart-params :as mp])
            (clojure.contrib [duck-streams :as ds]))
  (:gen-class))

(defn render [t] (apply str t))


(deftemplate index "templates/index.html" [])
(deftemplate upload-success "templates/success.html" [file_path] [:div.uploadedImage] 
             (html-content (str "<img src=\"" file_path "\">")))

(defn upload-file
  [file]
  (ds/copy (file :tempfile) (ds/file-str (str "public/images/" (get file :filename))))
  (render (upload-success (str "public/images/" (get file :filename))))
)

(defn list
  [files]
  (render (image-file-list ["image1" "image2" "image3"]))
)

;Routes定義
(defroutes public-routes
          (GET "/" [] (render (index)))
          (mp/wrap-multipart-params
             (POST "/file" {params :params} (upload-file (get params :file))))
          (route/files "/public" )   
      )

;(defn start-app []
;  (future (run-jetty (var public-routes) {:port 8000})))

(def app (handler/site public-routes))
