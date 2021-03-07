(ns clojure-sandbox.core-test
  (:require [clojure-sandbox.core :as core]
            [midje.sweet :refer [fact
                                 facts
                                 =>]]))
(facts "about 'contrived-test'"
       (fact "the contrived test should return true"
             (core/contrived-test) => true))
