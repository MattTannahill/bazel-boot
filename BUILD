package(default_visibility = ["//visibility:public"])

load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "bazel-boot-lib",
    srcs = glob(["src/main/java/com/matt_tannahill/bazel_boot/*.java"]),
    resources = glob(["src/main/resources/**"]),
    deps = [
        "@maven//:org_springframework_spring_web",
        "@maven//:org_springframework_boot_spring_boot",
        "@maven//:org_springframework_boot_spring_boot_autoconfigure"
    ],
)

load("@io_bazel_rules_docker//java:image.bzl", "java_image")

java_image(
    name = "bazel-boot",
    main_class = "com.matt_tannahill.bazel_boot.BazelBootApplication",
    runtime_deps = [
        "@maven//:org_springframework_boot_spring_boot_starter_web",
        ":bazel-boot-lib"
    ],
)

load("//:junit5.bzl", "java_junit5_test")

java_junit5_test(
    name = "bazel-boot-test",
    srcs = glob(["src/test/java/com/matt_tannahill/bazel_boot/*Tests.java"]),
    test_package = "com.matt_tannahill.bazel_boot",
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
        ":bazel-boot-lib"
    ],
)