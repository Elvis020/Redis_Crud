package com.elvisdoingredis;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


//Adding the following annotations prevents us from creating getters and setters

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Product_Entity")
public class Product_Entity implements Serializable {
    @Id
    private int id;
    private String name;
    private int qty;
    private long price;
}
