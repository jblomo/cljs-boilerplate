(ns countdown.core
  (:require [goog.dom :as dom]
            [goog.Timer :as timer]
            [goog.fx.dom.FadeOut :as fade]
            [goog.ui.Button :as button]
            [goog.events :as events]
            [goog.ui.Component.EventType :as c-event-type]
            [goog.fx.Animation.EventType :as a-event-type]
            [goog.fx.dom.PredefinedEffect :as effect]))

(defn TextResize [element start end time opt_acc]
  (let [pe-start (if (goog/isNumber start) (array start) start)
        pe-end (if (goog/isNumber end) (array end) end)]
    (.call goog.fx.dom.PredefinedEffect (js* "this") element pe-start pe-end time opt_acc)

    (when (or (not= (count pe-start) 1)
              (not= (count pe-end) 1))
      (throw (js/Error "start and end sizes must be 1D")))))
(goog/inherits TextResize goog.fx.dom.PredefinedEffect)

(set! (.. TextResize -prototype -updateStyle)
      (fn []
        (set! (.. (js* "this") -element -style -fontSize)
              (str (get (.-coords (js* "this")) 0) "px"))))

(declare countdown-button)

(defn start-countdown [n]
  (let [counter (dom/getElement "countdown")]
    (if (pos? n)
      (do
        (dom/setTextContent counter n)
        ; fade and shrink, but restore defaults when done
        ; You could accomplish this with a more complex subclass of
        ; PredefinedEffect, but then you wouldn't get to play with events!
        (doto (goog.fx.dom.FadeOut. counter 1000)
          (events/listen a-event-type/END #(.. counter -style (removeProperty "opacity")))
          (. play))
        (doto (TextResize. counter 200 10 1000)
          (events/listen a-event-type/END #(.. counter -style (removeProperty "font-size")))
          (. play))
        (timer/callOnce (partial start-countdown (dec n)) 1000))
      (do ; else restore button
        (dom/setTextContent counter "")
        (countdown-button)))))

(defn countdown-button []
  (doto (goog.ui.Button. "Start Countdown")
    (.addClassName "btn btn-large btn-success")
    (.render (dom/getElement "countdown"))
    (.setTooltip "This Javascript was written in ClojureScript!")
    (events/listen c-event-type/ACTION #(start-countdown 10))))

(defn init []
  (countdown-button))
