# What is this project about?
This project provides an API to retrieve events for a git repository by passing in the owner name and event type.hubeventsservice' instead.

# How do I build and bring up the application?
./gradlew clean build bootRun

### How do I test it?
After bringing up the local server, it can be tested by executing the following curl command - 

curl "http://localhost:8080/repositories/{repository}/events?owner={owner}&event-type={event-type}"


Example: curl "http://localhost:8080/repositories/hellogitworld/events?owner=githubtraining&event-type=ForkEvent"

### Trade offs
The integration test is incomplete right now. I was wanting to leverage wiremock, but dont want to spend more time on this.


