package ftao.demo.service.impl;

import ftao.demo.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {
    @Autowired
    private ProductCategoryServiceImpl productCategoryService;
    @Test
    public void findOne() {
        ProductCategory p=productCategoryService.findOne(1);
        Assert.assertEquals(new Integer(1),p.getCategoryId());

    }

    @Test
    public void findAll() {
        System.out.print(productCategoryService.findAll().get(0).toString());

    }

    @Test
    public void findByCategoryTypeIn() {
    }

    @Test
    public void save() {
    }
}