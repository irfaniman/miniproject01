// package vttp2022.ssf.MiniProject01.repositories;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.redis.core.RedisTemplate;
// import org.springframework.stereotype.Repository;

// import vttp2022.ssf.MiniProject01.models.Albums;



// @Repository
// public class UserRepository {
    
//     @Autowired
//     private RedisTemplate<String,Object> redisTemplate;
        
        
//     public void saveUser(String name, List<Albums> albums){
//         redisTemplate.opsForValue().set(name, albums);
//     }
    
//     public List<Albums> getUserAlbums(String name){
//         List<Albums> albums = (List<Albums>)redisTemplate.opsForValue().get(name);
//         return albums;
//     }
// }
