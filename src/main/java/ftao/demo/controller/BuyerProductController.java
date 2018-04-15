package ftao.demo.controller;

import ftao.demo.VO.ProductInfoVO;
import ftao.demo.VO.ProductVO;
import ftao.demo.VO.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.Arrays;

/***
 * 卖家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {


    @GetMapping("/list")
    public ResultVO list()
    {
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        ProductVO productVO=new ProductVO();
        ProductInfoVO productInfoVO=new ProductInfoVO();
        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
        resultVO.setData(Arrays.asList(productVO));

        return resultVO;
    }

}
