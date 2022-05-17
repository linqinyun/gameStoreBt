package com.lin.gamestroe.dao;

import com.lin.gamestroe.BaseTest;
import com.lin.gamestroe.entity.ProductCategory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest extends BaseTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testAquerylist(){
        List<ProductCategory> productCategories = productCategoryDao.queryProductCategoryList();
        assertEquals(0, productCategories.size());
    }
    @Test
    public void testBInsert(){
        Long categoryId = 1103l;
        String name = "模拟经营游戏";
        Long parentCategoryId = 1101l;
        Date createTime = new Date();
        Date updateTime = new Date();
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(categoryId);
        productCategory.setName(name);
        productCategory.setParentCategoryId(parentCategoryId);
        productCategory.setCreateTime(createTime);
        productCategory.setUpdateTime(updateTime);
        int i = productCategoryDao.insertProductCategory(productCategory);
        assertEquals(1,i);
    }
    @Test
    public void testCUpdate(){
        Long categoryId = 1102l;
        String name = "动作游戏";
        Date updateTime = new Date();
        int i = productCategoryDao.updateProductCategory(categoryId,name,updateTime);
        assertEquals(1,i);
    }
    @Test
    public void testDquerylist(){
        List<ProductCategory> productCategories = productCategoryDao.queryProductCategoryList();
        assertEquals(1, productCategories.size());
    }
    @Test
    @Ignore
    public void testEDelete(){
        Long categoryId = 1102l;
        int i = productCategoryDao.deleteProductCategory(categoryId);
        assertEquals(1,i);
    }
}
