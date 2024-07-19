package com.sisumupa.sisumupa_backend;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class DatabaseIntegrationTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDatabaseConnection() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            assertNotNull(connection);
        }
    }
}
