FROM ubuntu

RUN apt-get update && apt-get install -y apache2 golang git
RUN a2enmod status

RUN rm /etc/apache2/sites-enabled/000-default.conf
COPY 000-default.conf /etc/apache2/sites-enabled/

RUN service apache2 restart

RUN mkdir ~/go
RUN export GOPATH=$HOME/go
RUN export PATH=$PATH:$GOROOT/bin:$GOPATH/bin
RUN go get github.com/neezgee/apache_exporter
RUN ln -s ~/go/bin/apache_exporter /usr/bin


CMD /usr/sbin/apache2ctl start ; /usr/bin/apache_exporter