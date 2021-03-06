(defproject kuona-api "0.0.1"
  :description "Kuona HTTP API service"
  :url "https://github.com/kuona/kuona-project"
  :min-lein-version "2.0.0"
  :main kuona-api.main
  :aot [kuona-api.main]
  :license {:name "Apache License 2.0"
            :url  "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.cli "0.3.5"]
                 [org.clojure/tools.logging "0.3.1"]
                 [log4j/log4j "1.2.17" :exclusions [javax.mail/mail
                                                    javax.jms/jms
                                                    com.sun.jdmk/jmxtools
                                                    com.sun.jmx/jmxri]]
                 [compojure "1.5.1"]
                 [ring/ring-jetty-adapter "1.5.0"]
                 [ring/ring-defaults "0.2.1"]
                 [ring/ring-json "0.4.0"]
                 [cheshire "5.6.3"]
                 [clojurewerkz/elastisch "3.0.0-beta2"]
                 [slingshot "0.12.2"]
                 [kuona-core "0.0.2"]]
  :plugins [[lein-ring "0.9.7"]
            [lein-midje "3.0.0"]]
  :ring {:handler kuona-api.handler/app}
  :profiles {:dev     {:dependencies [[javax.servlet/servlet-api "2.5"]
                                      [ring/ring-mock "0.3.0"]
                                      [midje "1.9.0-alpha5"]
                                      [com.jcabi/jcabi-log "0.17.1"]]}
             :uberjar {:aot :all}})
