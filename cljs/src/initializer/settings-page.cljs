(ns initializer.settings-page
  (:require [goog.dom :as dom]))

(def actions 
  {:init (fn [] (dom/setTextContent (dom/getElement "keyword") (str (keyword? :keyword))))})
