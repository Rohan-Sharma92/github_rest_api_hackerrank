# Hackerrank Exercise: GitHUB Query API

## Description
The following project aims at developing a spring-boot REST application with APIs based on GitHub Query API. 

## Mandatory Requirements

This application creates REST APIs to solve these requirements:

1. The service should be able to erase all the events by the DELETE request at /erase. The HTTP response code should be 200.
2. The service should be able to add a new event by the POST request at /events. The event JSON is sent in the request body. If an event with the same id already exists then the HTTP response code should be 400, otherwise, the response code should be 201.
3. The service should be able to return the JSON array of all the events by the GET request at /events. The HTTP response code should be 200. The JSON array should be sorted in ascending order by event ID.
4. The service should be able to return the JSON object of an event using a GET request at /events/{id}. If the requested  event does not exist then HTTP response code should be 404, otherwise, the response code should be 200.
5. The service should be able to return the JSON array of all the events which are performed by the actor using a GET request at /events/actors/{id}. If the requested actor events do not exist then HTTP response code should be 404, otherwise, the response code should be 200.
6. The service should be able to return the JSON array of all the events which are performed on a repository using a GET request at /events/repos/{repoId}. If the requested repository events do not exist then HTTP response code should be 404, otherwise, the response code should be 200.
7. The service should be able to return the JSON array of all the events which are performed on a repository by a specific actor using a GET request at /events/repos/{repoId}/actors/{actorId}. If the requested events do not exist then HTTP response code should be 404, otherwise, the response code should be 200.

## Technologies

- Java 8
- Spring Boot 2.1.1.RELEASE
- Hibernate
- REST API
- POSTMAN

## Installation and Deployment

Install: git clone https://github.com/Rohan-Sharma92/github_rest_api_hackerrank.git

Build: mvn clean install -Dtest=TestSuite

Deploy: mvn spring-boot:run

## Examples for each call

- {{URL}}/events
- {{URL}}/events/{id}
- {{URL}}/events/actors/{id}
- {{URL}}/events/repos/{id}
- {{URL}}/events/repos/{repoId}/actors/{actorId}
- {{URL}}/erase

Import the request collections provided in GItHub REST API- SpringBoot.postman_collection.json in POSTMAN 