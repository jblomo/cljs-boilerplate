(ns cljs-boilerplate.core
  (:require [closure.templates.core :as templ]
            [closure.templates.tofu :as tofu]
            [closure.templates.fileset :as fileset]
            [compojure.route :as route]
            [cljs-boilerplate.settings :as settings])
  (:use compojure.core
        ring.adapter.jetty
        cljs-devmode.ring-middleware))

(templ/deftemplate html [title]
                   {:title title})

(templ/deftemplate body []
                   {})

(templ/deftemplate settings []
                   {})

(templ/deftemplate footer []
                   {})

(defn- wrap-templates-recompile [handler]
  (if settings/*dev-mode*
    (fn [& args]
      ; TODO only compile templates that have changed
      (tofu/compile!)
      (apply handler args))
    handler))

(defroutes app
           (HEAD "/" [] "") ; beanstalk monitoring
           (GET "/" []
                (str
                  (html "cljs-boilerplate")
                  (body)
                  (footer)))
           (GET "/settings" []
                (str
                  (html "cljs-boilerplate")
                  (settings)
                  (footer)))
           (route/resources "/"))

(def the-app
  (-> app
    ; TODO only wrap handlers that use templates
    (wrap-templates-recompile)
    (wrap-cljs-forward "/cljs")))

(defn -main []
  (let [port (Integer/parseInt
               (or (System/getenv "PORT")
                   settings/*default-port*))]
    (run-jetty app {:port port})))
