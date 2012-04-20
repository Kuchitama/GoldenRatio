(ns GoldenRatio.test.views
  (:use [GoldenRatio.views])
  (:use [clojure.test]))

(deftest test-set-id ;; set-id正常系
  (is (= (set-id [1 2 3]) {0 1, 1 2, 2 3})
      "id設定失敗"))

(deftest test-table-body ;; table-bodyの正常系
  (is (= (list-table-body ["test1"]) 
         "<tr><td>0</td><td>test1</td></tr>")
      "失敗"))

(deftest test-table-body ;; table-bodyの正常系
  (is (= (list-table-body ["test1" "test2" "test3"]) 
         "<tr><td>0</td><td>test1</td></tr><tr><td>1</td><td>test2</td></tr><tr><td>2</td><td>test3</td></tr>")
      "失敗"))

