// package vttp2022.ssf.MiniProject01.repositories;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.data.redis.core.RedisTemplate;
// import org.springframework.data.redis.core.ValueOperations;

// import java.time.Duration;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.redis.core.RedisTemplate;
// import org.springframework.data.redis.core.ValueOperations;
// import org.springframework.stereotype.Repository;

// import vttp2022.ssf.miniproject1v2.models.Artist;



// @Repository
// public class ArtistsRepository {

// 	@Autowired
// 	private RedisTemplate<String, String> redisTemplate;

// 	public void save(Artist article) {
// 		redisTemplate.opsForValue().set(article.getId(), article.toJson().toString());
// 		redisTemplate.expire(article.getId(), Duration.ofMinutes(5));
// 	}

// 	public void save(List<Artist> artist) {
// 		Map<String, String> map = new HashMap<>();
// 		for (Artist art: artist)
// 			map.put(art.getId(), art.toJson().toString());
// 		redisTemplate.opsForValue().multiSet(map);

// 		for (String id: map.keySet())
// 			redisTemplate.expire(id, Duration.ofMinutes(5));
// 	}

// 	public Optional<NewsArticle> get(String id) {
// 		if (!redisTemplate.hasKey(id))
// 			return Optional.empty();
// 		String data = redisTemplate.opsForValue().get(id);
// 		return Optional.of(NewsArticle.create(data));
// 	}
// }
