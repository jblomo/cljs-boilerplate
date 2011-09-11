(ns cljs-boilerplate.settings.global
  (:require [cljs-boilerplate.settings :as settings]))

(def ^:private dev-mode true)

(def options
  (merge {:dev-mode dev-mode}
         (settings/custom-options *ns*)))
