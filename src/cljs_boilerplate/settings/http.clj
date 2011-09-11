(ns cljs-boilerplate.settings.http
  (:require [cljs-boilerplate.settings :as settings]
            [cljs-boilerplate.settings.global :as global]))

(def options
  (merge {:default-port
          (if-let [system-port (System/getenv "PORT")]
            (Integer/parseInt system-port)
            (if (:dev-mode global/options)
              3000
              80))}
         (settings/custom-options *ns*)))
