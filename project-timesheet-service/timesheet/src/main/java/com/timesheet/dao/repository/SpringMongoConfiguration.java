//package com.timesheet.dao.repository;
//
//import com.mongodb.MongoClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//@Configuration
//@EnableMongoRepositories(basePackages = {"com.timesheet.dao.repository"}, considerNestedRepositories = true)
//public class SpringMongoConfiguration {
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception {
//        return new MongoTemplate(new MongoClient("<my_host>"), "SHAM");
//    }
//}
