package(default_visibility = ["//visibility:public"])

load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "spring-board-lib",
    srcs = glob(["src/main/java/com/MattTannahill/spring_board/*.java"]),
    resources = glob(["src/main/resources/**"]),
    deps = [
        "@maven//:org_springframework_spring_web",
        "@maven//:org_springframework_boot_spring_boot",
        "@maven//:org_springframework_boot_spring_boot_autoconfigure"
    ],
)

load("@io_bazel_rules_docker//java:image.bzl", "java_image")

java_image(
    name = "spring-board",
    main_class = "com.MattTannahill.spring_board.SpringBoardApplication",
    runtime_deps = [
        "@maven//:org_springframework_boot_spring_boot_starter_web",
        ":spring-board-lib"
    ],
)

load("//:junit5.bzl", "java_junit5_test")

java_junit5_test(
    name = "spring-board-test",
    srcs = glob(["src/test/java/com/MattTannahill/spring_board/*Tests.java"]),
    test_package = "com.MattTannahill.spring_board",
    deps = [
        "@maven//:org_hamcrest_hamcrest",
        "@maven//:org_springframework_spring_beans",
        "@maven//:org_springframework_spring_test",
        "@maven//:org_springframework_boot_spring_boot_test",
        "@maven//:org_springframework_boot_spring_boot_test_autoconfigure",
    ],
    runtime_deps = [
        "@maven//:org_springframework_boot_spring_boot_starter_test",
        "@maven//:org_springframework_boot_spring_boot_starter_web",
        ":spring-board-lib"
    ],
)