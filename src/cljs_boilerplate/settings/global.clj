(ns cljs-boilerplate.settings.global
  (:require [cljs-boilerplate.settings :as settings]))

(def ^:private dev-mode false)

(def options
  (merge {:dev-mode dev-mode}
         (settings/custom-options *ns*)))
