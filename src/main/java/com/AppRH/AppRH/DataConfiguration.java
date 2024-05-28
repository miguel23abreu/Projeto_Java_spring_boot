package com.AppRH.AppRH;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

//o "@" se refere à uma notação
@Configuration //isso indica que ela é uma classe de configuração
public class DataConfiguration {
    @Bean //serve para trabalhar com importações de classes
    //método da qual fará a conexão com o banco de dados
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        try {
            dataSource.setDriverClassName("com.postgresql.cj.jdbc.Driver"); //set do nome do banco de dados
        }catch (exception e){
            System.out.println("metodo nao encontrado");
        }
        dataSource.setUrl("jdbc:postgresql://teste:5432/pessoa?useTimezone=true&serverTimezone=UTC");
        dataSource.setUsername("miguel");
        dataSource.setPassword("26102018");
        return dataSource;
    }
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.POSTGRESQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        adapter.setPrepareConnection(true);
        return adapter;
    }
}
