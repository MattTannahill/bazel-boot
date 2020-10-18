# Spring Board

A simple reference application using Spring Boot, Bazel, and Docker.

## Bazel

To build the Spring Boot app, package it into a 
container, and run in it on a local installation of Docker:

```bash
$ bazel run :spring-board
```

To run the tests:

```bash
$ bazel test :spring-board-test
```

## References

1. [junit5-jupiter-starter-bazel](https://github.com/junit-team/junit5-samples/tree/main/junit5-jupiter-starter-bazel)
1. [Spring Boot Dependency Versions](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-dependency-versions.html)