(ns cljs-boilerplate.settings.aws
  "Credentials needed for Beanstalk deploys"
  (:require [cljs-boilerplate.settings :as settings]))

(def options
  (merge {:credentials
          {:access-key "XXXXXXXXXXXXXXXXXXXX"
           :secret-key "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"}}
         (settings/custom-options *ns*)))
