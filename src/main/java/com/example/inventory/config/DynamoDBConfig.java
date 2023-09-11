package com.example.inventory.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.example.inventory")
public class DynamoDBConfig {
    @Value("${endpoint}")
    String endpoint;
    @Value("${accesskey}")
    String accesskey;
    @Value("${secretkey}")
    String secretkey;
    @Value("${region}")
    String region;

    @Bean
    public AmazonDynamoDB amazonDynamoDB(){
        return AmazonDynamoDBClientBuilder
            .standard()
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region))
            .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accesskey, secretkey)))
            .build();
    }
}
