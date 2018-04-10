package ftao.demo.service;

import ftao.demo.dataobject.ProductInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {
    ProductInfo findOne();
    List<ProductInfo> findUpAll();
    List<ProductInfo> findAll(Pageable pageable);
    ProductInfo save(ProductInfo productInfo);
}
