package com.lin.gamestroe.dao;

import com.lin.gamestroe.BaseTest;
import com.lin.gamestroe.entity.Product;
import com.lin.gamestroe.entity.ProductCategory;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductDaoTest extends BaseTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void testInsertProduct(){
        Product product = new Product();
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1102l);
        product.setProductCategory(productCategory);
        product.setName("只狼·影逝二度");
        product.setNormalPrice(new BigDecimal(249.67));
        product.setPromotionPrice(new BigDecimal(149.34));
        product.setProductDesc("不死斩与狼的故事");
        product.setImgPath("https://baidu.com");
        product.setTotal(200);
        product.setPriority(100);
        product.setIsActive(1);
        product.setCreateTime(new Date());
        product.setUpdateTime(new Date());
        int i = productDao.insertProduct(product);
        assertEquals(1,i);
    }
    @Test
    public void testQueryProductList(){
        List<Product> productList = productDao.queryProductList();
        for (Product pro: productList){
            System.out.println(pro.getProductCategory().getName());
        }
//        assertEquals(1,productList.size());
    }

    @Test
    public void testQueryproductCount(){
        int count = productDao.queryproductCount();
        System.out.println(count);
    }

    @Test
    public void testUpdateProduct(){
        Product product = new Product();
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1103l);
        product.setProductCategory(productCategory);
        product.setName("城市·天际线");
        product.setNormalPrice(new BigDecimal(649.67));
        product.setPromotionPrice(new BigDecimal(249.34));
        product.setProductDesc("建立属于自己的城市");
        product.setImgPath("https://baidu.com");
        product.setTotal(100);
        product.setPriority(50);
        product.setUpdateTime(new Date());
        product.setProductId(1l);
        int i = productDao.updateProduct(product);
        assertEquals(1,i);
    }

}
