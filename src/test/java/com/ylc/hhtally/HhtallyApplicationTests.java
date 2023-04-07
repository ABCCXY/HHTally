package com.ylc.hhtally;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class HhtallyApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(LocalDate.now().toString());
    }

}
