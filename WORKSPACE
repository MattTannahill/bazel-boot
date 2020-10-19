load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "2.8"
RULES_JVM_EXTERNAL_SHA = "79c9850690d7614ecdb72d68394f994fef7534b292c4867ce5e7dec0aa7bdfad"
HAMCREST_VERSION = "2.2"
SPRING_VERSION = "5.2.9.RELEASE"
SPRING_BOOT_VERSION = "2.3.4.RELEASE"
JUNIT_JUPITER_VERSION = "5.7.0"
JUNIT_PLATFORM_VERSION = "1.7.0"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:specs.bzl", "maven")
load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "org.hamcrest:hamcrest:%s" % HAMCREST_VERSION,
        "org.springframework:spring-beans:%s" % SPRING_VERSION,
        "org.springframework:spring-test:%s" % SPRING_VERSION,
        "org.springframework:spring-web:%s" % SPRING_VERSION,
        "org.springframework.boot:spring-boot:%s" % SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-autoconfigure:%s" % SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-starter-web:%s" % SPRING_BOOT_VERSION,
        maven.artifact(
            group = "org.springframework.boot",
            artifact = "spring-boot-starter-test",
            version = SPRING_BOOT_VERSION,
            exclusions = [
                "org.junit.vintage:junit-vintage-engine"
            ]
        ),
        "org.springframework.boot:spring-boot-test:%s" % SPRING_BOOT_VERSION,
        "org.springframework.boot:spring-boot-test-autoconfigure:%s" % SPRING_BOOT_VERSION,
    ],
    repositories = [
        "http://uk.maven.org/maven2",
        "https://jcenter.bintray.com/",
    ],
)

load(":junit5.bzl", "junit_jupiter_java_repositories", "junit_platform_java_repositories")

junit_jupiter_java_repositories(
    version = JUNIT_JUPITER_VERSION,
)

junit_platform_java_repositories(
    version = JUNIT_PLATFORM_VERSION,
)

http_archive(
    name = "io_bazel_rules_docker",
    sha256 = "4521794f0fba2e20f3bf15846ab5e01d5332e587e9ce81629c7f96c793bb7036",
    strip_prefix = "rules_docker-0.14.4",
    urls = ["https://github.com/bazelbuild/rules_docker/releases/download/v0.14.4/rules_docker-v0.14.4.tar.gz"],
)

load(
    "@io_bazel_rules_docker//repositories:repositories.bzl",
    container_repositories = "repositories",
)

container_repositories()

load(
    "@io_bazel_rules_docker//repositories:deps.bzl", 
    container_deps = "deps",
)

container_deps()

load(
    "@io_bazel_rules_docker//repositories:pip_repositories.bzl", 
    container_pip_deps = "pip_deps",
)

container_pip_deps()

load(
    "@io_bazel_rules_docker//java:image.bzl",
    _java_image_repos = "repositories",
)

_java_image_repos()