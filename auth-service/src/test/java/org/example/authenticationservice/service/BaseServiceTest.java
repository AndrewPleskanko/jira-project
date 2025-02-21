package org.example.authenticationservice.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Testcontainers
public abstract class BaseServiceTest {

    public static PostgreSQLContainer<?> postgresContainer =
            new PostgreSQLContainer<>(DockerImageName.parse("postgres:16-alpine"))
                    .withDatabaseName("integration-tests-db")
                    .withUsername("sa")
                    .withPassword("sa");

    @BeforeEach
    public void startContainer() {
        postgresContainer.start();
        if (!postgresContainer.isRunning()) {
            throw new IllegalStateException("PostgreSQL container failed to start");
        }
        log.info("PostgreSQL container started");
    }

    @AfterEach
    public void stopContainer() {
        postgresContainer.stop();
        log.info("PostgreSQL container stopped");
    }
}
