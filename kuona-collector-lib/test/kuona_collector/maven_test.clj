(ns kuona-collector.maven-test
  (:require [midje.sweet :refer :all]
            [clojure.data.xml :refer :all]
            [kuona-collector.maven :refer :all]
            [kuona-collector.util :refer :all]))

(defn find-tag
  [m v]
  (keep #(when (= (val %) v) (key %)) m))

(defn tag
  [name value]
  (element name {} value))

(def maven-dependency-plugin
  (element :dependency {} (list
                           (tag :groupId "org.apache.maven.plugins")
                           (tag :artifactId "maven-dependency-plugin")
                           (tag :version "2.10")
                           (tag :type "maven-plugin"))))

(facts "about loading pom.xml files"
       (fact
        (let [pom (load-pom-file "test/pom.xml")]
          (clojure.pprint/pprint pom)
          (first (:content (first (filter #(= (:tag %) :modelVersion) (:content pom))))) => "4.0.0"
          )))
