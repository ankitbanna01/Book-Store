// package com.ankit.bookstore.order;
//
// import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
//
// import org.springframework.boot.test.context.TestConfiguration;
// import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
// import org.springframework.context.annotation.Bean;
// import org.testcontainers.containers.PostgreSQLContainer;
// import org.testcontainers.containers.RabbitMQContainer;
// import org.testcontainers.utility.DockerImageName;
// import org.wiremock.integrations.testcontainers.WireMockContainer;
//
// @TestConfiguration(proxyBeanMethods = false)
// class TestcontainersConfiguration {
//
//    static WireMockContainer wiremockServer = new WireMockContainer("wiremock/wiremock:3.5.2-alpine");
//
//    @Bean
//    WireMockContainer wiremockServer() {
//        wiremockServer.start();
//        configureFor(wiremockServer.getHost(), wiremockServer.getPort());
//        return wiremockServer;
//    }
//
//    @Bean
//    @ServiceConnection
//    PostgreSQLContainer<?> postgresContainer() {
//        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:16-alpine"));
//    }
//
//    @Bean
//    @ServiceConnection
//    RabbitMQContainer rabbitContainer() {
//        return new RabbitMQContainer(DockerImageName.parse("rabbitmq:4.0.4-management"));
//    }
// }
