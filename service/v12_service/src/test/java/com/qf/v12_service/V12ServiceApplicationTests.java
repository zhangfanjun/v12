package com.qf.v12_service;

import com.qf.v12_service.product.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class V12ServiceApplicationTests {
    @Autowired
    private ProductService service;
    @Test
    public void contextLoads() {
        long id=1l;
        System.out.println(service.selectByPrimaryKey(id));
    }

}
