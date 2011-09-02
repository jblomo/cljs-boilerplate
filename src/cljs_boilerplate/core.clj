(ns cljs-boilerplate.core
  (:require [ring.middleware.closure-templates :as templ]
            [compojure.route :as route]
            [compojure.route.clojurescript :as cljsc]
            [cljs-boilerplate.settings :as settings])
  (:use compojure.core
        [clojure.java.io :only (as-file resource)]
        [cljs-boilerplate.templates.util :only (template-response)]
        ring.adapter.jetty))

(def template-globals
  {:goog.DEBUG settings/*dev-mode*})

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
                                 {:dynamic settings/*dev-mode*
                                  :globals template-globals})

           (if settings/*dev-mode* ; only compile cljs in dev mode
             (cljsc/compiled-clojurescript "/cljs/")
             (constantly nil))

           (route/resources "/")
           ; TODO fix (not-found URL)
           (route/not-found (as-file (resource "public/404.html"))))

(defn -main []
  (let [port (Integer/parseInt
               (or (System/getenv "PORT")
                   settings/*default-port*))]
    (run-jetty app {:port port})))
