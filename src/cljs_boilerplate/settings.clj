(ns cljs-boilerplate.settings)

(def *dev-mode* false)

; use a string for compatibility with ENV
(def *default-port* (if *dev-mode* "3000" "80"))

(def *aws-credentials* {:access-key "XXXXXXXXXXXXXXXXXXXX"
                            :secret-key "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"})

(try 
  (require 'cljs-boilerplate.settings.custom)
  (doseq [[var value] (ns-publics 'cljs-boilerplate.settings.custom)]
    (intern *ns* var @value))
  (catch Exception e
    (println "WARNING: error loading custom settings:" e)))

