package io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }
    @Test
    public void whenLoadAppLines() {
       // String path = "./data/pair_without_comment.properties";
        Config config = new Config("../app.properties");
        config.load();
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("hibernate.connection.url"), is("jdbc:postgresql://127.0.0.1:5432/trackstudio"));
        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
        assertThat(config.value("hibernate.connection.password"), is("password"));
    }
}
//hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
//hibernate.connection.url=jdbc:postgresql://127.0.0.1:5432/trackstudio
//hibernate.connection.driver_class=org.postgresql.Driver
//hibernate.connection.username=postgres
//hibernate.connection.password=password


