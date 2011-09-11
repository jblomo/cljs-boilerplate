(ns initializer.settings-page
  (:require [goog.dom :as dom])
  (:require-macros [cljs-boilerplate.settings.cljs :as settings]))

(settings/defoptions global cljs-boilerplate.settings.global)

(def actions 
  {:init (fn []
           (dom/setTextContent (dom/getElement "keyword") (str (keyword? :keyword)))
           (dom/setTextContent (dom/getElement "dev-mode") (str (:dev-mode global))))})
