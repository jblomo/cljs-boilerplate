(ns cljs-boilerplate.settings)

; This controls the behavior of the app:
; true - recompile CLJS, templates, use uncompressed files in resources-dev/
; false - use precompiled and minified resources in resources/
(def *dev-mode* true)

(def namespace-sym (symbol "totally.other.ns"))
(def my-ns (create-ns namespace-sym))

(intern my-ns 'totally (if *dev-mode* "hello" "world"))
