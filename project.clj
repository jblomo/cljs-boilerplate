(def aws 
  (try (load-file "test-resouces/settings/aws.clj")
    (catch Exception e {})))
; TODO lein not including test-resources when running tasks
;(use '[cljs-boilerplate.settings.aws :rename {options aws}])

(defproject
  cljs-boilerplate "0.4.0"
  :description "An attempt to bring together the best practices of Clojure, ClojureScript, HTML5 Boilerplate, and Google Closure."
  :url "https://github.com/jblomo/cljs-boilerplate"
  :dependencies [[org.clojure/clojure "1.3.0"] 
                 [ring/ring-jetty-adapter "1.0.2"]
                 [compojure "1.0.1" :exclusions [org.clojure/clojure org.clojure/clojure-contrib]]
                 [org.apache.httpcomponents/httpclient "4.0.1"] ; for beanstalk/tomcat support
                 [ring.middleware.closure-templates "0.0.3"]
                 [compojure.route.clojurescript "0.3.5"]]
  :dev-dependencies [[lein-ring "0.5.4" :exclusions [org.clojure/clojure org.clojure/clojure-contrib]]
                     [lein-beanstalk "0.2.1" :exclusions [org.clojure/clojure org.clojure/clojure-contrib]]
                     [org.apache.ant/ant "1.8.2"]]
  :aws ~(:credentials aws)
  :ring {:handler cljs-boilerplate.core/app})
