import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    idea
    id("org.springframework.boot") version "2.4.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.4.21"
    kotlin("plugin.spring") version "1.4.21"
    id("com.revolut.jooq-docker") version "0.3.6"
    id("com.diffplug.spotless") version "5.1.1"
}

apply {
    plugin("com.diffplug.spotless")
    plugin("idea")
    plugin("java")
}

group = "com.talentfront"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_15

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    kotlin {
        ktlint("0.38.1").userData(mapOf("insert_final_newline" to "true"))
    }
}

repositories {
    mavenCentral()
    jcenter()
}

jooq {
    image {
        repository = "mysql"
        tag = "8.0.15"
        envVars = mapOf(
            "MYSQL_ROOT_PASSWORD" to "mysql",
            "MYSQL_DATABASE" to "mysql")
        containerName = "mysql"
        readinessProbe = { host: String, port: Int ->
            arrayOf("sh", "-c", "until mysqladmin -h$host -P$port -uroot -pmysql ping; do echo wait; sleep 1; done;")
        }
    }
    db {
        username = "root"
        password = "mysql"
        name = "mysql"
        port = 3306
    }
    jdbc {
        schema = "jdbc:mysql"
        driverClassName = "com.mysql.cj.jdbc.Driver"
        jooqMetaName = "org.jooq.meta.mysql.MySQLDatabase"
        urlQueryParams = "?useSSL=false"
    }
}

tasks {
    generateJooqClasses {
        schemas = arrayOf("db")
        basePackageName = "com.talentfront.jooq"
        inputDirectory.setFrom(project.files("./src/main/resources/flyway/sql"))
        outputDirectory.set(project.layout.projectDirectory.dir("./src/main/java/models"))
        flywayProperties = mapOf("flyway.placeholderReplacement" to "false")
        excludeFlywayTable = true
        customizeGenerator {
            database.withExcludes("flyway_schema_history")
        }
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.data:spring-data-commons")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.github.microutils", "kotlin-logging", "1.8.3")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.mockk:mockk:1.10.5")

    // JOOQ
    implementation("org.jooq:jooq:3.13.1")
    implementation("com.zaxxer", "HikariCP", "3.4.5")
    implementation("org.springframework.boot", "spring-boot-starter-jooq")
    implementation("mysql:mysql-connector-java:8.0.15")
    jdbc("mysql:mysql-connector-java:8.0.15")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "15"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

gradle.taskGraph.whenReady {
    if (this.allTasks.any { it.name.contains("build") } || this.allTasks.any { it.name.contains("spotless") }) {
        tasks.getByName("generateJooqClasses").enabled = false
    }
}
