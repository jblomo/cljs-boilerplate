(ns cljs-boilerplate.settings.cljs
  ; require settings modules that you want available to ClojureScript
  (:require cljs-boilerplate.settings.global))

(defmacro defoptions
  "`def`s the given name with the option map from settings-ns.
  
  Defined as a macro so that it runs at compile time for cljs so that it can
  be used in ClojureScript. eg.
  
  (defconfigs globals cljs-boilerplate.settings/options)"
  [name settings-ns]
  `(def ^:export ~name ~(deref (ns-resolve settings-ns 'options))))

