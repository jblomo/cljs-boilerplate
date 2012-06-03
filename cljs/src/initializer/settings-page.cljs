(ns initializer.settings-page
  (:require [goog.dom :as dom])
  (:require-macros [project.settings.cljs :as settings]))

(settings/defoptions global project.settings.global)

(def actions 
  {:init (fn []
           (dom/setTextContent (dom/getElement "keyword") (str (keyword? :keyword)))
           (dom/setTextContent (dom/getElement "dev-mode") (str (:dev-mode global))))})
