package com.example.inventory.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

@DynamoDBTable(tableName = "inventory")
@Data
public class Entity {

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBAttribute(attributeName = "year")
    private int year;

    @DynamoDBAttribute(attributeName = "make")
    private String make;

    @DynamoDBAttribute(attributeName = "model")
    private String model;

    @DynamoDBAttribute(attributeName = "trim")
    private String trim;

    @DynamoDBAttribute(attributeName = "msrp")
    private float msrp;

    @DynamoDBAttribute(attributeName = "numInStock")
    private int numInStock;
}
