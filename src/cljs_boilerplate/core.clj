(ns cljs-boilerplate.core
  (:require [closure.templates.core :as templ]
            [compojure.route :as route])
  (:use compojure.core
        ring.adapter.jetty
        cljs-devmode.ring-middleware))

(templ/deftemplate hello-name [name]
                   {:name name})

(templ/deftemplate html [title]
                   {:title title})

(templ/deftemplate body []
                   {})

(templ/deftemplate footer []
                   {})
(defroutes app
           (GET "/" []
                (str
                  (html "cljs-boilerplate")
                  (body)
                  (footer)))
           (route/resources "/"))

(def the-app
  (-> app
    (wrap-cljs-forward "/cljs")))

(defn -main []
  (run-jetty (var the-app) {:port 8080}))
