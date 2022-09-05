package vttp2022.ssf.MiniProject01.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class RealTimeRepo {
    
    @Autowired
    @Qualifier("redislab")
    private RedisTemplate<String, String> redisTemplate;

    public void save(String flight_icao, String payload) {

        ValueOperations<String, String> valueOp = redisTemplate.opsForValue();
        valueOp.set(flight_icao, payload); // , Duration.ofSeconds(cacheTime)
        System.out.printf("%s is saved\n", flight_icao);
    }

    public String get(String flight_icao) {

        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
        String value = valueOps.get(flight_icao);
        System.out.printf("%s retrieved successfully\n", flight_icao);
        return value;
    }
} 
