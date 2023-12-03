package com.ahamdah.s2.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor@NoArgsConstructor@Builder
@Document(indexName = "transaction" ,createIndex = true)
@TypeAlias("com.ahamdah.model.Transaction")
public class Transaction {
    @Id
    private String id;
    private String sender_id;
    private String receiver_id;
    @Field(type = FieldType.Double)
    private double amount;
    @Field(type = FieldType.Auto)
    private Status status;

}
