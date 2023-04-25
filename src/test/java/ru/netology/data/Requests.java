package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class Requests {

    private static final String dataBaseUrl = System.getProperty("datasource.url");

    private Requests() {

    }

    @SneakyThrows
    public static Connection getConnect() {
        return DriverManager.getConnection(dataBaseUrl, "app", "pass");
    }

    @SneakyThrows
    public static String getPaymentGateStatus() {
        QueryRunner runner = new QueryRunner();
        String SqlStatus = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        try (var connection = getConnect()) {
            String result = runner.query(connection, SqlStatus, new ScalarHandler<>());
            return result;
        }
    }

    @SneakyThrows
    public static String getCreditGateStatus() {
        QueryRunner runner = new QueryRunner();
        String SqlStatus = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
        try (var connection = getConnect()) {
            String result = runner.query(connection, SqlStatus, new ScalarHandler<>());
            return result;
        }
    }

    @SneakyThrows
    public static void clearDataBase() {
        QueryRunner runner = new QueryRunner();
        try (var connection = getConnect()) {
            runner.execute(connection, "DELETE FROM credit_request_entity");
            runner.execute(connection, "DELETE FROM order_entity");
            runner.execute(connection, "DELETE FROM payment_entity");
        }
    }
}
