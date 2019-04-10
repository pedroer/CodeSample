# First Thing to Run the Project is Install a Redis Server or Point the "application.properties" to a installed one.
 
##Fedora (https://computingforgeeks.com/how-to-install-redis-on-fedora-29-fedora-28/)
sudo dnf -y install redis

##Ubuntu (https://tecadmin.net/install-redis-ubuntu/)
sudo apt-get install redis-server

##Windows (https://redislabs.com/blog/redis-on-windows-10/)

##Mac (https://medium.com/@petehouston/install-and-config-redis-on-mac-os-x-via-homebrew-eb8df9a4f298)


#Second we need to run the redis that we just installed

redis-server &

#Third just run the project with maven or import it on an IDE and run as a spring boot project

mvn spring-boot:run

