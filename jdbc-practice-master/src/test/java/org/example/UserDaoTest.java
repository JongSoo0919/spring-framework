package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import static org.assertj.core.api.Assertions.*;

public class UserDaoTest {
    @BeforeEach
    void setup(){
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("db_schema.sql"));
        DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource());
    }

    @Test
    void createTest() throws Exception{
        UserDao userDao = new UserDao();
        userDao.create(new User("ID", "PASSWORD", "NAME", "EMAIL"));

        User user = userDao.findById("ID");
        assertThat(user).isEqualTo(new User("ID", "PASSWORD", "NAME", "EMAIL"));
    }
}
