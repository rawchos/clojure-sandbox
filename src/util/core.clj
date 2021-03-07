(ns util.core
  (:require [clojure.java.io :as io]))

(defn read-lines [input-file]
  (with-open [rdr (io/reader input-file)]
    (doall (line-seq rdr))))

(defn read-str [filename]
  (slurp filename))