(ns cljs-boilerplate.settings)

(def ^:dynamic *dev-mode* true)

; use a string for compatibility with ENV
(def ^:dynamic *default-port* (if *dev-mode* "3000" "80"))

(def ^:dynamic *aws-credentials*
  {:access-key "XXXXXXXXXXXXXXXXXXXX"
   :secret-key "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"})

; 'import' custom settings that will override the defaults above
(try 
  (require 'cljs-boilerplate.settings.custom)
  (doseq [[var value] (ns-publics 'cljs-boilerplate.settings.custom)]
    (intern *ns* var @value))
  (catch Exception e
    (println "WARNING: error loading custom settings:" e)))

