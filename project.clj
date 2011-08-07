(defproject
  cljs-boilerplate "0.0.2-SNAPSHOT"
  ; comment below out for production
  :resources-path "resources-dev"
  :description "An attempt to bring together the best practices of Clojure, ClojureScript, HTML5 Boilerplate, and Google Closure."
  :url "https://github.com/jblomo/cljs-boilerplate"
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [compojure "0.6.5"]
                 [closure-templates-clj "0.0.1"]
                 [ring/ring-jetty-adapter "0.3.11"]]
  :dev-dependencies [[cljs-devmode "0.1.0-SNAPSHOT"]
                     [lein-ring "0.4.5"]
                     [org.apache.ant/ant "1.8.2"]]
  :ring {:handler cljs-boilerplate.core/the-app})

