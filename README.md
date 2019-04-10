# Code Sample using a Public Charity Api

This api uses an public api, do cache of the requests using redis so if we search the same thing it dont waste the public api.

# Java - Using Spring Boot and Angular 6 for the Frontend

The Spring Boot project is using the port 8080, so if you change this, you will need to change the port also 
at the frontend where the calls are made, in the services.

If you change the port of the angular 6 project, you will need to update the backend where we 
allow the cross origin from the port 4200 localhost.

I'm using redis in port 6379 in localhost, so if you change, you need to update spring properties too.


#JAVAPROJECT
## First Thing to Run the Project is Install a Redis Server or Point the "application.properties" to a installed one.
 
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

#AngularProject
Do a "npm install" and after "ng serve".
