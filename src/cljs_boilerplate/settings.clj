(ns cljs-boilerplate.settings)

; This controls the behavior of the app:
; true - recompile CLJS, templates, use uncompressed files in resources-dev/
; false - use precompiled and minified resources in resources/
(def *dev-mode* true)
