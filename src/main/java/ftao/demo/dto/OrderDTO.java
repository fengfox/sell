package ftao.demo.dto;

import ftao.demo.dataobject.OrderDetail;
import ftao.demo.enums.OrderStatusEnum;
import ftao.demo.enums.PayStatusEnum;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    private String orderId;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private Double orderAmount;
    private Integer orderStatus;
    private Integer payStatus;
    private String buyerName;
    private Date createTime;
    private Date updateTime;
    private List<OrderDetail> orderDetailList;
}
