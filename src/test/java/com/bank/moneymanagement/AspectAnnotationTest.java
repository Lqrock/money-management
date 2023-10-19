package com.bank.moneymanagement;

import com.bank.moneymanagement.aspect.Log;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AspectAnnotationTest {

    @Test
    @Log
    void testIfAspectWorksWithLogAnnotation() {

    }

}
