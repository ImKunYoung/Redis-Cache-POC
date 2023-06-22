package com.poc.redis;

import com.poc.redis.RedisCachePocApp;
import com.poc.redis.config.AsyncSyncConfiguration;
import com.poc.redis.config.EmbeddedKafka;
import com.poc.redis.config.EmbeddedRedis;
import com.poc.redis.config.EmbeddedSQL;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { RedisCachePocApp.class, AsyncSyncConfiguration.class })
@EmbeddedRedis
@EmbeddedKafka
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public @interface IntegrationTest {
}
