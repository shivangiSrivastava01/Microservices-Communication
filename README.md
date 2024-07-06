PROMETHEUS-DEMO
======================================================
1) Build RESTFUL Web service (with an endpoint)
2) Add prometheus.yml file (configurations can be checked from the prometheus file in the project)
3) Define the scrape_configs property in prometheus.yml file as below
   scrape_configs:
  - job_name: 'test_path' -- this is your application name
    metrics_path: '/actuator/prometheus' -- this is the endpoint where the data for prometheus metrics is present
    scrape_interval: 1s
    static_configs:
      - targets: [ '192.168.70.95:7025' ]-- here 192.168.70.95 is ip adress of my system and 7025 is the port for the api that we have build in our java application
4) Now we need to upload the prometheus.yml file on docker.
5) Follow below steps for this:
  a) Pull the prometheus image from docker by using command (docker pull prom/prometheus)
  b) Run the command docker run -p 9090:9090 -v /Users/shivangisrivastava/Documents/MyProjects/ServiceForCommunication/serviceB/src/main/resources/prometheus.yml prom/prometheus
      where 9090 is the port at which prometheus runs and the path mentioned is the path for preometheus file in the java project
  c) Access url http://192.168.70.95:9090 - this will open the prometheus dashboard and you can select any metrics to monitor the api's status and performance

6) But here is a catch!!! There can be a possibility that step 5b does not work and docker actually does not reflect the prometheus file from the java project we created.
   In this case we can actually open docker desktop and go to the prometheus container-> go to the files section-> search for prometheus.yml file and copy the changes from
   our local prometheus file to the one in docker and restart-> follow step 5c after this
   
