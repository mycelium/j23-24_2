plugins {
    id("java")
}

group = "ru.spbstu.java.spring"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.springframework:spring-core:6.1.5")
    implementation("org.springframework:spring-context:6.1.5")
    implementation("org.springframework:spring-web:6.1.5")
    implementation("org.springframework:spring-webmvc:6.1.5")
    implementation("org.apache.tomcat.embed:tomcat-embed-core:11.0.0-M19")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:11.0.0-M19")
    implementation("com.fasterxml.jackson.core:jackson-core:2.17.0")
    implementation("org.xerial:sqlite-jdbc:3.45.3.0")
    implementation("org.mybatis:mybatis-spring:3.0.3")
    implementation("org.springframework.data:spring-data-jdbc:3.2.5")
    implementation("org.hibernate.orm:hibernate-community-dialects:6.5.0.Final")
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.1.0-M2")

    //implementation("org.springframework:org.springframework.web.servlet:3.2.2.RELEASE")

}

tasks.test {
    useJUnitPlatform()
}