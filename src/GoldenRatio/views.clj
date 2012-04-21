(ns GoldenRatio.views
  (:use [net.cgrand.enlive-html])
  (:use [clojure.contrib.str-utils]))

(def absolute-path ;;conf
  "http://localhost:9000")

(deftemplate index ;;index.html
  "templates/index.html" [])

(deftemplate upload-success ;;success
   "templates/success.html" [filepath]
  [:div.uploadedImage]
  (html-content (str "<img src=\"" filepath "\">")))

(def list-table-header  
  "<th>#</th>
   <th>ファイル名</th>")

(defn set-id ;; idを付けたMapにする
  [coll]
  (apply sorted-map (apply concat (zipmap (range (count coll)) coll)))
)

(defn list-table-body ;; テーブルのrowを生成する
  [td-list]
  (let [data-map (set-id td-list)]
  (str-join "" (map #(format "<tr><td>%s</td><td>%s</td></tr>" (key %) (val %)) data-map)))
)

(deftemplate image-file-list "templates/list.html" [file-list] ;;list
  [:div.file-list]
  (html-content 
    (str "<table><thead><tr>" list-table-header "</tr></thead>" (list-table-body file-list) "</table>")))

(deftemplate show-image "templates/showImage.html" [file-name] ;;list
  [:article#image-path]
  (html-content 
;    (str "<input type=\"hidden\" id=\"image\" value=\"" file-name "\" />")
     (str "<img src=\"" file-name "\" >")
  )
)
