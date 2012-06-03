(ns project.webapp
  (:require [ring.middleware.closure-templates :as templ]
            [compojure.route :as route]
            [compojure.route.clojurescript :as cljsc]
            [project.settings.global :as global]
            [project.settings.http :as http])
  (:use compojure.core
        [clojure.java.io :only (as-file resource)]
        [project.templates.util :only (template-response)]
        ring.adapter.jetty))

(def template-globals
  {:goog.DEBUG (:dev-mode global/options)})

(defroutes template-routes
           (GET "/" [] (template-response
                {:title "project"
                 :template ["project.webapp.header"
                            "project.webapp.main"
                            "project.webapp.footer"]}))
           (GET "/settings" [] (template-response
                {:title "settings - project"
                 :template ["project.webapp.header"
                           "project.webapp.settings"
                           "project.webapp.footer"]})))

(defroutes app
           (HEAD "/" [] "") ; beanstalk monitoring
           (templ/wrap-templates template-routes
                                 (resource "soy")
                                 {:dynamic (:dev-mode global/options)
                                  :globals template-globals})

           (if (:dev-mode global/options) ; only compile cljs in dev mode
             (cljsc/compiled-clojurescript "/cljs/")
             (constantly nil))

           (route/resources "/")
           ; TODO fix (not-found URL)
           (route/not-found (as-file (resource "public/404.html"))))

(defn -main []
    (run-jetty app {:port (:default-port http/options)}))
