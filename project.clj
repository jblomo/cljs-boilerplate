(defproject
  cljs-boilerplate "0.0.1-SNAPSHOT"
  ; comment below out for production
  :resources-path "resources-dev"
  :description "Example applications of ClojureScript"
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [compojure "0.6.5"]
                 [closure-templates-clj "0.0.1"]
                 [ring/ring-jetty-adapter "0.3.11"]]
  :dev-dependencies [[cljs-devmode "0.1.0-SNAPSHOT"]
                     [lein-ring "0.4.5"]
                     [org.apache.ant/ant "1.8.2"]]
  :main cljs-boilerplate.core
  :ring {:handler cljs-boilerplate.core/the-app})

