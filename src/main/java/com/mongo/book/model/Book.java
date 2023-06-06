package com.mongo.book.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;

@Document("books")
@Data

public class Book {

    @Id
    public String id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("price")
    public BigDecimal price;

    @JsonProperty("category")
    public String category;

    @JsonProperty("author")
    public String author;

    @JsonProperty("year")
    public Integer year;

}
