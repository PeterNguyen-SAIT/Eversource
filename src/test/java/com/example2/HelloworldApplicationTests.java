package com.example2;

import com.example2.controllers.archive.WebController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloworldApplicationTests {

    @Autowired
    private WebController controller;

    @Test
    void contextLoads() {
        Assertions.assertThat(controller).isNotNull();
    }

}
