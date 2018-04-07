package ftao.demo.service;

import ftao.demo.dataobject.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    ProductCategory findOne(Integer id);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTpyeList);
    ProductCategory save(ProductCategory productCategory);

}
