(def aws 
  (try (load-file "dev-resouces/settings/aws.clj")
    (catch Exception e {})))
; TODO lein not including test-resources when running tasks
;(use '[cljs-boilerplate.settings.aws :rename {options aws}])

(defproject
  cljs-boilerplate "0.4.5"
  :description "An attempt to bring together the best practices of Clojure, ClojureScript, HTML5 Boilerplate, and Google Closure."
  :url "https://github.com/jblomo/cljs-boilerplate"
  :dependencies [[org.clojure/clojure "1.4.0"] 
                 [ring/ring-jetty-adapter "1.1.0"]
                 [compojure "1.1.0"]
                 [org.apache.httpcomponents/httpclient "4.0.1"] ; for beanstalk/tomcat support
                 [ring.middleware.closure-templates "0.4.0"]
                 [compojure.route.clojurescript "0.4.0"]]
  :profiles {:dev {:dependencies [[lein-ring "0.7.1"]
                                  [lein-beanstalk "0.2.2"]
                                  [org.apache.ant/ant "1.8.2"]]}}
  :aws ~(:credentials aws)
  :ring {:handler cljs-boilerplate.core/app}
  :min-lein-version "2.0.0")
