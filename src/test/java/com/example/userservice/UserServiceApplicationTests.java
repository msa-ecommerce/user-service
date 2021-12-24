package com.example.userservice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Date;

@SpringBootTest
@Slf4j
class UserServiceApplicationTests {

    @Test
    void contextLoads() {
        final long currentTimeJava8 = Instant.now().toEpochMilli();

        log.info(currentTimeJava8+"");
        log.info(new Date(System.currentTimeMillis())+"");
    }

}
