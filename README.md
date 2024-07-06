# PROMETHEUS-DEMO

## Build RESTFUL Web Service

1. Create an endpoint for your service.

## Add prometheus.yml File

2. Add a `prometheus.yml` file to your project. You can check the configurations from the prometheus file in the project.

### Define the `scrape_configs` Property

3. Configure the `scrape_configs` property in the `prometheus.yml` file as follows:

```yaml
scrape_configs:
  - job_name: 'test_path'           # This is your application name
    metrics_path: '/actuator/prometheus'  # This is the endpoint where the data for prometheus metrics is present
    scrape_interval: 1s
    static_configs:
      targets: [ '192.168.70.95:7025' ]  # 192.168.70.95 is the IP address of your system, and 7025 is the port for the API built in your Java application
```

## Upload prometheus.yml File on Docker

4. Follow these steps to upload the `prometheus.yml` file on Docker:

   a) Pull the Prometheus image from Docker:
   ```
   docker pull prom/prometheus
   ```
   b) Run the Prometheus container with the specified configuration:
   ```
   docker run -p 9090:9090 -v /Users/shivangisrivastava/Documents/MyProjects/ServiceForCommunication/serviceB/src/main/resources/prometheus.yml prom/prometheus
   ```
   `9090` is the port at which Prometheus runs.
   The path mentioned is the path to the prometheus.yml file in your Java project.

   c) Access the Prometheus dashboard:
   Open http://192.168.70.95:9090 to view the Prometheus dashboard and monitor the API's status and performance.

Troubleshooting
5. If step 4b does not work and Docker does not reflect the prometheus.yml file from your Java project:

   - Open Docker Desktop.
   - Go to the Prometheus container.
   - Navigate to the Files section.
   - Search for the prometheus.yml file.
   - Copy the changes from your local prometheus.yml file to the one in Docker.
   - Restart the Prometheus container.
   - Follow step 4c to access the Prometheus dashboard.
