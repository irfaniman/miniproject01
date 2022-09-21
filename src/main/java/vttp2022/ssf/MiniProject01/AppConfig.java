package vttp2022.ssf.MiniProject01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

// @Configuration
// public class AppConfig {

//     @Value("${spring.redis.host}")
//     private String redisHost;
//     @Value("${spring.redis.port}")
//     private Integer redisPort;
//     @Value("${spring.redis.database}")
//     private Integer redisDatabase;
//     @Value("${spring.redis.username}")
//     private String redisUsername;
//     @Value("${REDIS_PASSWORD}")
//     private String redisPassword;

//     @Bean("redislab")
//     public RedisTemplate<String, String> initRedisTemplate() {
//         // Configure the Redis database
//         RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
//         redisConfig.setHostName(redisHost);
//         redisConfig.setPort(redisPort);
//         redisConfig.setDatabase(redisDatabase);
//         redisConfig.setUsername(redisUsername);
//         redisConfig.setPassword(redisPassword);

//         // Create an instance of the Jedis driver
//         JedisClientConfiguration jedisConfig = JedisClientConfiguration.builder().build();

//         // Create a factory for jedis connection
//         JedisConnectionFactory jedisFac = new JedisConnectionFactory(redisConfig, jedisConfig);
//         jedisFac.afterPropertiesSet();

        
//         RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//         redisTemplate.setConnectionFactory(jedisFac);
        
//         redisTemplate.setKeySerializer(new StringRedisSerializer());
//         redisTemplate.setValueSerializer(new StringRedisSerializer());

//         return redisTemplate;
//     }

@Configuration
public class AppConfig {

	@Value("${spring.redis.host}")
	private String redisHost;

	@Value("${spring.redis.port}")
	private Integer redisPort;

	@Value("${spring.redis.database}")
	private Integer redisDB;

	@Value("${spring.redis.username}")
	private String redisUser;

	@Value("${REDIS_PASSWORD}")
	private String redisPassword;


	@Bean
	public RedisTemplate<String, Object> createRedisTemplate() {

		final RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(createJedisConnectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new StringRedisSerializer());

		return template;
	}

	@Bean
	public JedisConnectionFactory createJedisConnectionFactory() {

		final RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
		redisConfig.setHostName(redisHost);
		redisConfig.setPort(redisPort);
		redisConfig.setDatabase(redisDB);
		redisConfig.setUsername(redisUser);
		redisConfig.setPassword(redisPassword);

		final JedisClientConfiguration jedisClientConfig = JedisClientConfiguration
				.builder().build();
		final JedisConnectionFactory jedisFac = new JedisConnectionFactory(redisConfig, jedisClientConfig);
		jedisFac.afterPropertiesSet();
		return jedisFac;
    }
} 


