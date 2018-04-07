package ftao.demo.service.impl;

import ftao.demo.dataobject.ProductCategory;
import ftao.demo.repository.ProductCategoryRepository;
import ftao.demo.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory findOne(Integer id) {
        return productCategoryRepository.findOne(id);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTpyeList) {
        return findByCategoryTypeIn(categoryTpyeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return save(productCategory);
}
    }
