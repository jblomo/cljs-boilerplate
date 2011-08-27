(use 'cljs-boilerplate.settings)

(defproject
  cljs-boilerplate "0.0.3-SNAPSHOT"
  :resources-path ~(if *dev-mode* "resources-dev" "resources")
  :description "An attempt to bring together the best practices of Clojure, ClojureScript, HTML5 Boilerplate, and Google Closure."
  :url "https://github.com/jblomo/cljs-boilerplate"
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [compojure "0.6.5"]
                 [closure-templates-clj "0.0.1"]
                 [org.apache.httpcomponents/httpclient "4.0.1"] ; for beanstalk/tomcat support
                 [ring/ring-jetty-adapter "0.3.11"]]
  :dev-dependencies [[cljs-devmode "0.1.0-SNAPSHOT"]
                     [lein-ring "0.4.5"]
                     [lein-beanstalk "0.2.0"]
                     [org.apache.ant/ant "1.8.2"]]
  :aws ~*aws-credentials*
  :ring {:handler cljs-boilerplate.core/the-app})
