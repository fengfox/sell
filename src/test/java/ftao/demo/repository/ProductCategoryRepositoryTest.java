package ftao.demo.repository;

import ftao.demo.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;
    @Test
    public void findOneTest()
    {
        ProductCategory productCategory=repository.findOne(1);
        System.out.println(productCategory.toString());
    }
    @Test
    public void saveTest()
    {

    }
    @Test
    public void findByCategoryTypeInTest()
    {
        List<Integer>  pc= Arrays.asList(1);

        List<ProductCategory> result=repository.findByCategoryTypeIn(pc);
        System.out.println(result.toString());
        Assert.assertNotEquals(0, result.size());

    }
}