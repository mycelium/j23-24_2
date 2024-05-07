package ru.spbstu.java.spring.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.MyBatisJdbcConfiguration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@EnableJdbcRepositories("ru.spbstu.java.spring.repositories")
@Import(MyBatisJdbcConfiguration.class)
@PropertySource("classpath:database.properties")
public class DatabaseConfig extends AbstractJdbcConfiguration {
    @Value( "${DATABASE.URL}" )
    private String jdbcUrl;

    @Bean
    DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL).build();
    }

    @Bean
    NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    TransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    SqlSessionFactoryBean sqlSessionFactoryBean() {
        var sqlSessionFactoryBean = new SqlSessionFactoryBean();

        try {
            DriverManager.getConnection(jdbcUrl).get;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        sqlSessionFactoryBean.;
    }

}
