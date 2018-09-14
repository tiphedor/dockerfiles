FROM jenkinsci/blueocean:latest

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

USER root

RUN apk --no-cache add shadow sudo
RUN usermod -aG docker jenkins
RUN usermod -aG root jenkins


USER jenkins

COPY security.groovy /usr/share/jenkins/ref/init.groovy.d/security.groovy
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN xargs /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt
