package ru.job4j.integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BasicDataSource {

    private final String driverClassName;
    private final String url;
    private final String username;
    private final String password;
    private final int maxTotal;

    public BasicDataSource(Builder builder) {
        this.driverClassName = builder.driverClassName;
        this.url = builder.url;
        this.username = builder.username;
        this.password = builder.password;
        this.maxTotal = builder.maxTotal;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url, this.username, this.password);
    }

    public static class Builder {
        private String driverClassName;
        private String url;
        private String username;
        private String password = "";
        private int maxTotal;

        Builder buildDriverClassName(String driverClassName) {
            this.driverClassName = driverClassName;
            return this;
        }

        Builder buildUrl(String url) {
            this.url = url;
            return this;
        }

        Builder buildUsername(String username) {
            this.username = username;
            return this;
        }

        Builder buildPassword(String password) {
            this.password = password;
            return this;
        }

        Builder buildMaxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
            return this;
        }

        BasicDataSource build() {
            return new BasicDataSource(this);
        }

    }

}
