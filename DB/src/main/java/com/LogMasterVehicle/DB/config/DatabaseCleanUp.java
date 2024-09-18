package com.LogMasterVehicle.DB.config;

import jakarta.annotation.PreDestroy;
import  org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import  org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Configuration
public class DatabaseCleanUp {

    @Autowired
    private DataSource dataSource;

    @Bean
    public DatabaseCleanup databaseCleanup(){
        return new DatabaseCleanup(dataSource);
    }

    public static class DatabaseCleanup{
        private DataSource dataSource;
        private final Logger logger = org.slf4j.LoggerFactory.getLogger(DatabaseCleanup.class);

        public DatabaseCleanup(DataSource dataSource){
            this.dataSource = dataSource;
        }

        @PreDestroy
        public void dropDatabaseTable(){
            try(Connection connection = dataSource.getConnection()){
                Statement statement = connection.createStatement();
                statement.executeUpdate("DROP TABLE IF EXISTS Vehicle_Information");
                statement.executeUpdate("DROP TABLE IF EXISTS maintenance_and_repair");
                statement.executeUpdate("DROP TABLE IF EXISTS  fuel_log");
                statement.executeUpdate("DROP TABLE IF EXISTS insurance_logs");
                statement.executeUpdate("DROP TABLE IF EXISTS vehicle_registraion");
                logger.info("Table dropped successfully");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
