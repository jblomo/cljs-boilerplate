(ns initializer.core
  (:require [initializer.main-page :as main-page]
            [initializer.settings-page :as settings-page]
            [goog.dom :as dom])
  (:require-macros [cljs-boilerplate.settings.cljs :as settings]))

; Based on the "Garber-Irish implementation" of page init scripts.
; Actions are triggered based based on the class and id of the body element

(comment ns-* and *ns* are undefined
(defn find-actions
  "Given a tuple, (namespace alias as a symbol, namespace), return the tuple
  (namespace alias as a keyword, actions hashmap for namespace or nil).  Used to
  construct an alias to actions map."
  [[als namesp]]
  (let [ns-actions (ns-resolve namesp 'actions)]
    [(keyword als)
     (when ns-actions @ns-actions)]))

(def actions
  (into {} (map find-actions (ns-aliases *ns*)))))

(def actions
  {:main-page main-page/actions
   :settings-page settings-page/actions})

(defn trigger [body-class & [body-id]]
  "Run the action associated with the class and, optionally, id of the body
  element.  If the body-id is empty, then run the action assoicated with :init"
  (let [class-key (keyword body-class)
        id-key    (if (empty? body-id) :init (keyword body-id))]
    (when-let [action (get-in actions [class-key id-key])]
      (action))))

(defn load-events []
  "Iterate through the classes of the body element, and trigger all associated
  actions."
  (let [body-id (.. (js* "document") body id)]
    (doseq [body-class  (.. (js* "document") body className (split #"\s+"))]
      (trigger body-class)
      (when-not (empty? body-id)
        (trigger body-class body-id)))))

; this will be run at the end of the minimized script evaluation
(load-events)
