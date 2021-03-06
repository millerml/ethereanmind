(defproject ethereanmind "0.0.1"
  :description "Some description"
  :url ""
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.229"]
                 [com.cognitect/transit-clj "0.8.285"]
                 [com.cognitect/transit-cljs "0.8.239"]
                 [ring "1.5.0"]
                 [compojure "1.5.1"]
                 [figwheel-sidecar "0.5.4-7"]
                 [org.omcljs/om "1.0.0-alpha48" :exclusions [cljsjs/react cljsjs/react-dom]]
                 [cljsjs/react-dom "15.4.2-2" :exclusions [cljsjs/react]]
                 [cljsjs/react-with-addons "15.4.2-2"]                 
                 [prismatic/om-tools "0.4.0"]
                 [com.stuartsierra/component "0.3.1"]
                 [com.cemerick/piggieback "0.2.1"]
                 [cljsjs/react-motion "0.4.5-0"  :exclusions [cljsjs/react]]
                 [org.clojure/core.async "0.2.395"]
                 [org.clojars.drcode/blueprint-cljs "0.1.1-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-figwheel "0.5.4-7"]
            [lein-ring "0.9.7"]]

  
  :ring {:handler backend.server/handler
         :port 8440}

  :resource-paths ["resources"]

  :source-paths ["src/cljs" "src/clj"]

  :profiles {:dev {:dependencies [[com.cemerick/piggieback "0.2.1"]
                                  [org.clojure/tools.nrepl "0.2.12"]]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}
             :uberjar {:aot :all}}
  
  :cljsbuild
  {:builds
   [{:id "advanced"
     :source-paths ["src/cljs"]
     :compiler {:output-to "resources/public/js/main.js"
                :output-dir "resources/public/js"
                :source-map "resources/public/js/main.js.map"
                :optimizations :advanced
                :externs ["blueprintjs-externs.js" "web3-externs.js"]
                :pretty-print false}}]}

  )

;; Front-End Development
;; 1. cider-jack-in-clojurescript
;; 2. In repl: user> (load-file "script/figwheel.clj")
