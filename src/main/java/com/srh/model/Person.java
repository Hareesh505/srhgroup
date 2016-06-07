package com.srh.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by RaghavendraKulkarni on 6/7/2016.
 */
@Data
@Document(collection = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ObjectId id;

    @Field(value = "personName")
    private String personName;

    @Field(value = "personBG")
    private String personBloodGroup;

    public Person(String personName,String personBloodGroup){
        this.personName = personName;
        this.personBloodGroup = personBloodGroup;
    }

}