(ns cljs-boilerplate.core
  (:require [closure.templates.core :as templ]
            [closure.templates.tofu :as tofu]
            [compojure.route :as route])
  (:use compojure.core
        ring.adapter.jetty
        cljs-devmode.ring-middleware))

; TODO move this setting into project.clj
; TODO use this variable to set goog.DEBUG
(def *debug* true)

(templ/deftemplate hello-name [name]
                   {:name name})

(templ/deftemplate html [title]
                   {:title title})

(templ/deftemplate body []
                   {})

(templ/deftemplate footer []
                   {})

(defn- wrap-templates-recompile [handler]
  (if *debug*
    (do
      ; TODO only compile templates that have changed
      (tofu/compile!)
      handler)
    handler))

(defroutes app
           (GET "/" []
                (str
                  (html "cljs-boilerplate")
                  (body)
                  (footer)))
           (route/resources "/"))

(def the-app
  (-> app
    ; TODO only wrap handlers that use templates
    (wrap-templates-recompile)
    (wrap-cljs-forward "/cljs")))

(defn -main []
  (run-jetty (var the-app) {:port 8080}))
