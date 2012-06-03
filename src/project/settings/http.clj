(ns project.settings.http
  (:require [project.settings :as settings]
            [project.settings.global :as global]))

(def options
  (merge {:default-port
          (if-let [system-port (System/getenv "PORT")]
            (Integer/parseInt system-port)
            (if (:dev-mode global/options)
              3000
              80))}
         (settings/custom-options *ns*)))
