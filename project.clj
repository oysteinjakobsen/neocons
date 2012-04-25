(defproject clojurewerkz/neocons "1.0.0-SNAPSHOT"
  :description "Neocons is an experimental idiomatic Clojure client for the Neo4J REST API"
  :license {:name "Eclipse Public License"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [org.clojure/data.json "0.1.2"]
                 [clj-http "0.3.6" :exclude [cheshire]]
                 [clojurewerkz/support "0.1.0-beta2"]]
  :test-selectors {:default        (fn [m] (and (not (:time-consuming m))
                                                (not (:http-auth m))))
                   :time-consuming :time-consuming
                   :focus          :focus
                   :indexing       :indexing
                   :cypher         :cypher
                   :http-auth      :http-auth
                   :all            (constantly true)}
  :source-paths ["src/clojure"]
  :profiles       {:1.4 {:dependencies [[org.clojure/clojure "1.4.0"]]}
                   :1.5 {:dependencies [[org.clojure/clojure "1.5.0-master-SNAPSHOT"]]}}
  :aliases        {"ci"  ["with-profile" "dev:dev,1.4"]
                   "all" ["with-profile" "dev:dev,1.4:dev,1.5"]}
  :repositories {"sonatype" {:url "http://oss.sonatype.org/content/repositories/releases"
                             :snapshots false
                             :releases {:checksum :fail :update :always}}
                 "sonatype-snapshots" {:url "http://oss.sonatype.org/content/repositories/snapshots"
                               :snapshots true
                               :releases {:checksum :fail :update :always}}}
  :java-source-paths ["src/java"]
  :warn-on-reflection true)
