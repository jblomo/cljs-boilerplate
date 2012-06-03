(ns project.templates.util
  (:use [ring.util.response :only (content-type)]))

(defn template-response
  "Given a data map for use with ring.middleware.closure-templates, return a
  response object for the wrapper."
  [data]
  (content-type {:body data} "text/html; charset=utf-8"))


