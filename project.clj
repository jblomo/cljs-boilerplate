(use 'cljs-boilerplate.settings)

(defproject
  cljs-boilerplate "0.3.0-SNAPSHOT"
  :description "An attempt to bring together the best practices of Clojure, ClojureScript, HTML5 Boilerplate, and Google Closure."
  :url "https://github.com/jblomo/cljs-boilerplate"
  :dependencies [[org.clojure/clojure "1.3.0-beta2"] 
                 [ring/ring-jetty-adapter "0.3.11"]
                 [compojure "0.6.5" :exclusions [org.clojure/clojure org.clojure/clojure-contrib]]
                 [org.apache.httpcomponents/httpclient "4.0.1"] ; for beanstalk/tomcat support
                 [ring.middleware.closure-templates "0.0.3-SNAPSHOT"]
                 [compojure.route.clojurescript "0.0.3-SNAPSHOT"]]
  :dev-dependencies [[lein-ring "0.4.5" :exclusions [org.clojure/clojure org.clojure/clojure-contrib]]
                     [lein-beanstalk "0.2.0" :exclusions [org.clojure/clojure org.clojure/clojure-contrib]]
                     [org.apache.ant/ant "1.8.2"]]
  :aws ~*aws-credentials*
  :ring {:handler cljs-boilerplate.core/app})
