package com.elvisdoingredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {


    @Autowired
    private RedisTemplate redisTemplate;

    public static final String HASH_KEY = "Product_Entity";

//    Writing querying functions
    public Product_Entity save(Product_Entity product_entity){
        redisTemplate.opsForHash().put(HASH_KEY,product_entity.getId(),product_entity);
        return product_entity;
    }

    public List<Product_Entity> findAll(){
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Product_Entity findProductById(int id){
        return (Product_Entity) redisTemplate.opsForHash().get(HASH_KEY,id);
    }


    public String deleteProduct(int id){
        redisTemplate.opsForHash().delete(HASH_KEY,id);
        return "Product deleted!";
    }
}
