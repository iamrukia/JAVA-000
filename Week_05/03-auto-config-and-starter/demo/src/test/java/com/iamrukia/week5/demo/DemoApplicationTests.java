package com.iamrukia.week5.demo;

import com.iamrukia.starter.School;
import com.iamrukia.starter.SchoolAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SchoolAutoConfiguration.class)
public class DemoApplicationTests {

    @Autowired
    School school;

    @Test
    public void test() {

        school.ding();

    }
}
