# Project Title

RESTful service for testing ExecutorService timeout

Run with `mvn jetty:run`

Test with `$curl http://localhost:8080/executor/{timeout}`

Replace timeout with seconds in integer format, e.g `$curl http://localhost:8080/executor/10`

Response should look like this `ERROR - Total Time: {timeout}`