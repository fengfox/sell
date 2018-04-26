package ftao.demo.controller;

import ftao.demo.VO.ProductInfoVO;
import ftao.demo.VO.ProductVO;
import ftao.demo.VO.ResultVO;
import ftao.demo.dataobject.ProductCategory;
import ftao.demo.dataobject.ProductInfo;
import ftao.demo.service.ProductCategoryService;
import ftao.demo.service.ProductInfoService;
import ftao.demo.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 * 卖家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/list")
    public ResultVO list()
    {
        //查询数据
        List<ProductInfo> productInfoList=productInfoService.findUpAll();
        //List<Integer> categoryTypeList=new ArrayList<>();
        //联查数据
        //传统方法
//        for(ProductInfo productInfo:productInfoList)
//        {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        List<Integer> categoryTypeList=productInfoList.stream()
                .map(e->e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList=productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //组装数据
        List<ProductVO> productVOList=new ArrayList<>();
        for(ProductCategory productCategory:productCategoryList)
        {
            ProductVO productVO=new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for(ProductInfo productInfo:productInfoList)
            {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType()))
                {
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);

        }

        return ResultVOUtil.success(productVOList);
    }

}
