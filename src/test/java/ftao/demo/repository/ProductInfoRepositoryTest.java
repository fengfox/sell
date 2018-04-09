package ftao.demo.repository;

import ftao.demo.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Test
    public void findByProductStatus() {

    }
    @Test
    public void saveTest()
    {
        ProductInfo pi=new ProductInfo();
        pi.setProductId("1");
        pi.setProductName("虾子");
        pi.setProductPrice(new BigDecimal(10.5));
        pi.setProductIcon("http://xxx.com");
        pi.setProductStock(4);
        pi.setProductDescription("好吃的虾子");
        pi.setProductStatus(1);
        pi.setCategoryType(2);
        Date dt=new Date();
        pi.setCreateTime(dt);
        pi.setUpdateTime(dt);
        productInfoRepository.save(pi);
    }
}