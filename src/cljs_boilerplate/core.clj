(ns cljs-boilerplate.core
  (:require [ring.middleware.closure-templates :as templ]
            [compojure.route :as route]
            [compojure.route.clojurescript :as cljsc]
            [cljs-boilerplate.settings.global :as global]
            [cljs-boilerplate.settings.http :as http])
  (:use compojure.core
        [clojure.java.io :only (as-file resource)]
        [cljs-boilerplate.templates.util :only (template-response)]
        ring.adapter.jetty))

(def template-globals
  {:goog.DEBUG (:dev-mode global/options)})

(defroutes template-routes
           (GET "/" [] (template-response
                {:title "cljs-boilerplate"
                 :template ["cljs_boilerplate.core.header"
                            "cljs_boilerplate.core.main"
                            "cljs_boilerplate.core.footer"]}))
           (GET "/settings" [] (template-response
                {:title "settings - cljs-boilerplate"
                 :template ["cljs_boilerplate.core.header"
                           "cljs_boilerplate.core.settings"
                           "cljs_boilerplate.core.footer"]})))

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
