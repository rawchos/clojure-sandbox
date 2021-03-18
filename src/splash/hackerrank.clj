(ns splash.hackerrank)

;; These were a couple of good questions. Should probably move them
;; to clojure-practice/interview-questions.

;; Question 1: For a given array of strings, group the words up that
;; are anagrams of one another. If a word has no anagrams within the
;; array, it will be a group by itself. Count the number of groups
;; you have.

;; This was my solution, it can definitely be refined.
(defn anagram-solution1 [words]
  (count
   (for [[chars group] (group-by frequencies words)]
     group)))

(defn anagram-solution2 [words]
  (-> (group-by frequencies words)
      (count)))

;; In this example, "listen" and "silent" are anagrams of each other
;; so they'll make 1 group, "cat" "kitten" and "salient" will each
;; be their own group for a total of 4 groups.
(def words ["cat" "kitten" "listen" "silent" "salient"])

(anagram-solution1 words)
(anagram-solution2 words)


;; Question 2: For an array of stock profits and a target, find all
;; unique pairs of stock targets that add up to the target amount.
;; Return the count of unique pairs.
(loop [matches []
       profits [1 3 46 1 3 9]
       target 47]
  (if-let [profit (first profits)]
    (loop [this-profit profit
           profits (rest profits)])))

(defn at-least-2? [profits num]
  (-> (filter #(= % num) profits)
      (count)
      (> 1)))

;; This was my solution (along with at-least-2?). Can probably be refined
;; a bit.
(defn stocksProfit [stock-profits target]
  (-> (let [profit-set (set stock-profits)
            target target]
        (loop [profits stock-profits
               matches []]
          (if-let [profit (first profits)]
            (if-let [match (profit-set (- target profit))]
              (recur (rest profits) (conj matches (if (= profit match)
                                                    (when (at-least-2? stock-profits profit)
                                                      #{profit})
                                                    #{profit match})))
              (recur (rest profits) matches))
            matches)))
      (set)
      (count)))

(stocksProfit [1 3 46 1 3 9] 47)
(stocksProfit [6 12 3 9 3 5 1] 12)

(at-least-2? [6 12 3 9 3 5 1] 3)

(conj [] nil)


7
6
12
3
9
3
5
1
12

(-> (conj [#{1 46}] [#{46 1}])
    (flatten)
    (set))

(conj [#{1 46}] #{46 1})