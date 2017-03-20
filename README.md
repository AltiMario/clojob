# clojob
Obsidian jobs management via Clojure

1) INSTALLATION
Install Obsidian as webapp on Tomcat (I used also postgresql as external DB)
for linux user: after the script generation, use dos2unix for webObsidian.sh and jetty/bin/jetty.sh
copy obsidian.war into webapp
run tomcat
    Credentials:
    user admin
    pwd changeme

2) NEW CLOJURE JOB
create a new clojure job (like core.cli) to do something
use uberjar to build the jar (clojob/target/uberjar/clojob-0.1.0-SNAPSHOT-standalone.jar)
create a new Java class (like MyJob.java) to call the clojure main method
create a new jar (myobsidianjob.jar) including obsidian-jarjar.jar (unfortunately there is no maven repo for it) and the previous clojob-xx.jar
stop tomcat
copy myobsidianjob.jar to tomcat/webapp/obsidian/WEB-INF/lib
start tomcat

3) NEW CLOJURE SCHEDULING (VIA REST API)
create a new scheduler (like scheduler.clj)

