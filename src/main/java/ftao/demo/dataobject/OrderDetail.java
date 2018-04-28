package ftao.demo.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class OrderDetail {
    @GeneratedValue
    @Id
    private String detailId;
    private String orderId;
    private String productId;
    private String productName;
    private Double productPrice;
    private Integer productQuantity;
    private String productIcon;
    private Date crteateTime;
    private Date updateTime;
    public OrderDetail(){}

}
