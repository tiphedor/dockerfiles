FROM jenkinsci/blueocean:latest

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

USER root

RUN apk update && apk --no-cache add shadow sudo sshpass maven
RUN apk add npm nodejs-current  --repository http://dl-3.alpinelinux.org/alpine/edge/testing/
RUN npm install -g npm
RUN usermod -aG docker jenkins
RUN usermod -aG root jenkins


USER jenkins

COPY security.groovy /usr/share/jenkins/ref/init.groovy.d/security.groovy
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN xargs /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt
