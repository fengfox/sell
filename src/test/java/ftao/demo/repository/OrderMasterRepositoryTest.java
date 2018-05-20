package ftao.demo.repository;

import ftao.demo.dataobject.OrderMaster;
import org.apache.tomcat.jni.Time;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest=new PageRequest(0,1)   ;
        Page<OrderMaster> result=orderMasterRepository.findByBuyerOpenid("110110",pageRequest);
        System.out.println(result.getTotalElements());
    }

    @Test
    public void saveTest()
    {
        OrderMaster orderMaster=new OrderMaster();
        Date d = new Date();
        orderMaster.setOrderId("123");
        orderMaster.setBuyerName("fengtao");
        orderMaster.setBuyerPhone("13880744145");
        orderMaster.setBuyerAddress("青年家园");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(1.2);
        orderMaster.setUpdateTime(d);
        orderMaster.setCreateTime(d);


        orderMasterRepository.save(orderMaster);
    }
}