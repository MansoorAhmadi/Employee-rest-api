package com.example.employeerestapi.configuration;

import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
public class DataSourceConfiguration {

    //    ### Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
//    @Bean
//    public DataSource datasource() {
//        return DataSourceBuilder.create()
//                .driverClassName("com.mysql.cj.jdbc.Driver")
//                .url("jdbc:mysql://localhost:3306/employee_management_system")
//                .username("root")
//                .password("@Abc123@")
//                .build();
//    }
//    ### Reason: Failed to determine a suitable driver class
}
