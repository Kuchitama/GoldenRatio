(ns GoldenRatio.views
  (:use [net.cgrand.enlive-html])
  (:use [clojure.contrib.str-utils]))

;conf
(def absolute-path "http://localhost:9000")

;index.html
(deftemplate index "templates/index.html" [])

;success
(deftemplate upload-success "templates/success.html" [filepath]
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

;list
(deftemplate image-file-list "templates/list.html" [file-list]
  [:div.file-list]
  (html-content 
    (str "<table><thead><tr>" list-table-header "</tr></thead>" (list-table-body file-list) "</table>")))


