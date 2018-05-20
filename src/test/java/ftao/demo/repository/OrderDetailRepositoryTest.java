package ftao.demo.repository;

import ftao.demo.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Test
    public void findByOrderId() {
        List<OrderDetail> result=orderDetailRepository.findByOrderId("1231");
    }
    @Test
    public void saveTest()
    {
        Date d=new Date();
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("1234561123");
        orderDetail.setOrderId("1231");
        orderDetail.setProductIcon("http://test.jpg");
        orderDetail.setProductId("321");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(10.2);
        orderDetail.setProductQuantity(2);
        orderDetail.setCreateTime(d);
        orderDetail.setUpdateTime(d);
        orderDetailRepository.save(orderDetail);
    }
}