(ns project.settings.cljs
  ; require settings modules that you want available to ClojureScript
  (:require project.settings.global))

(defmacro defoptions
  "`def`s the given name with the option map from settings-ns.
  
  Defined as a macro so that it runs at compile time for cljs so that it can
  be used in ClojureScript. eg.
  
  (defconfigs globals project.settings/options)"
  [name settings-ns]
  `(def ^:export ~name ~(deref (ns-resolve settings-ns 'options))))

