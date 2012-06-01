(defproject cljs-boilerplate "0.4.5"
  :description "An attempt to bring together the best practices of Clojure, ClojureScript, HTML5 Boilerplate, and Google Closure."
  :url "https://github.com/jblomo/cljs-boilerplate"
  :dependencies [[org.clojure/clojure "1.4.0"] 
                 [ring/ring-jetty-adapter "1.1.0"]
                 [compojure "1.1.0"]
                 [org.apache.httpcomponents/httpclient "4.0.1"] ; for beanstalk/tomcat support
                 [ring.middleware.closure-templates "0.4.0"]
                 [compojure.route.clojurescript "0.4.0"]]
  :profiles {:dev {:dependencies [[org.apache.ant/ant "1.8.2"]]}}
  :ring {:handler cljs-boilerplate.core/app}
  :min-lein-version "2.0.0")
