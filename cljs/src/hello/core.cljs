(ns hello.core
  (:require [goog.dom :as dom]
            [goog.Timer :as timer]
            [goog.fx.dom.FadeOut :as fade]
            [goog.fx.dom.PredefinedEffect :as effect]))

(defn ^:export greet [n]
  (str "Hello " n))

(defn ^:export TextResize [element start end time opt_acc]
  (let [pe-start (if (goog/isNumber start) (array start) start)
        pe-end (if (goog/isNumber end) (array end) end)]
    (.call goog.fx.dom.PredefinedEffect (js* "this") element pe-start pe-end time opt_acc)

    (when (or (not= (count pe-start) 1)
              (not= (count pe-end) 1))
      (throw (js/Error "start and end sizes must be 1D")))))
(goog/inherits TextResize goog.fx.dom.PredefinedEffect)

(set! (.. TextResize prototype updateStyle)
      (fn []
        (set! (.. (js* "this") element style fontSize)
              (str (get (.coords (js* "this")) 0) "px"))))

(defn ^:export start-countdown [n]
  (let [counter (dom/getElement "countdown")]
    (dom/setTextContent counter n)
    (. (goog.fx.dom.FadeOut. counter 1000) (play))
    (. (TextResize. counter 1000 10 1000) (play))
    (when (pos? n)
      (timer/callOnce (partial start-countdown (dec n)) 1000))))

(defn ^:export testing []
  (when (keyword? :keyword)
    (dom/setTextContent (dom/getElement "testing") "working")))
