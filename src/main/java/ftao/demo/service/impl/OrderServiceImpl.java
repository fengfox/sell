package ftao.demo.service.impl;

import ftao.demo.dataobject.OrderDetail;
import ftao.demo.dataobject.OrderMaster;
import ftao.demo.dataobject.ProductInfo;
import ftao.demo.dto.OrderDTO;
import ftao.demo.exception.SellException;
import ftao.demo.repository.OrderDetailRepository;
import ftao.demo.repository.OrderMasterRepository;
import ftao.demo.service.OrderService;
import ftao.demo.service.ProductInfoService;
import ftao.demo.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId=KeyUtil.genUniqueKey();
        BigDecimal orderAmount=new BigDecimal(0);
        //1.查询商品 （数量，价格）
        for(int i=0;i<orderDTO.getOrderDetailList().size();i++)
        {
            String id=orderDTO.getOrderDetailList().get(i).getDetailId();
            ProductInfo productInfo= productInfoService.findOne(id);
            if(productInfo==null)
            {
                throw new SellException();
            }
            //2.计算总价
            orderAmount=productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDTO.getOrderDetailList().get(i).getProductQuantity()))
                    .add(orderAmount);
            //3.写入订单数据库(OrderDetail)
            OrderDetail orderDetail=new OrderDetail();
            orderDetail.setOrderId(KeyUtil.genUniqueKey());
            orderDetail.setDetailId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);

        }

        //3.写入订单数据库(OrderMaster)
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMasterRepository.save(orderMaster);
        //4.扣库存
        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public List<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
