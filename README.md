[![GitPitch](https://gitpitch.com/assets/badge.svg)](https://gitpitch.com/ssheftel/spock-demo/master)

# spock-demo
project for demoing spock spock features

##

- `git checkout origin/demo-1-adding-spock`
- `git checkout origin/demo-2-controller-test`

Get All Trips - `curl -X GET  http://localhost:8080/trip`

Get Trip By Id - `curl -X GET http://localhost:8080/trip/1`

Post New Trip `curl -H "Content-Type: application/json" -X POST -d '{"model": "Corolla",  "averageMph": 29.7}' http://localhost:8080/trip`

