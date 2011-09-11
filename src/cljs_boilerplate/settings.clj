(ns cljs-boilerplate.settings
  "Settings are managed in the options Var of a namespace under this one.  The
  name space sets up defaults, then merges in customized settings from the
  resource path.  The resource path can vary depending on the deployment
  environment.  For production, the resource path is `resources/`.  During
  development, the `test-resources` path is checked first.  For example, to
  provide custom settings for the cljs-boilerplate.aws module in development,
  the last statement of `test-resources/settings/aws.clj` should be the custom
  options map."
  (:require [clojure.java.io :as jio]))

(defn custom-options
  "Given a namespace, load configs from resources directory that can override
  the defaults in this file.  Config files are clojure files whose last
  statement must be a map."
  [config-ns]
  (if-let [custom (jio/resource (str "settings"  java.io.File/separatorChar (last (.split (str config-ns) "\\.")) ".clj"))]
    (try
      (load-reader (jio/reader custom))
      (catch Exception e
        (println "WARNING: error loading custom settings:" e)
        {}))))
