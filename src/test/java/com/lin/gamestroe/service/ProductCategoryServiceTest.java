package com.lin.gamestroe.service;

import com.lin.gamestroe.BaseTest;
import com.lin.gamestroe.dto.ProductCategoryExecution;
import com.lin.gamestroe.entity.ProductCategory;
import com.lin.gamestroe.enums.ProductCategoryStateEnum;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryServiceTest extends BaseTest {
    @Autowired
    private ProductCategoryService productCategoryService;
    @Test
    public void getAlist(){
        List<ProductCategory> productCategories = productCategoryService.getProductCategoryList();
        assertEquals(2,productCategories.size());
    }
    @Test
    public void Bbind(){
        Long categoryId = 1103l;
        String name = "test1";
        Long parentCategoryId = 1101l;
        Date createTime = new Date();
        Date updateTime = new Date();
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(categoryId);
        productCategory.setName(name);
        productCategory.setParentCategoryId(parentCategoryId);
        productCategory.setCreateTime(createTime);
        productCategory.setUpdateTime(updateTime);
        ProductCategoryExecution pe = productCategoryService.bindProductCategory(productCategory);
        assertEquals(ProductCategoryStateEnum.SUCCESS.getState(),pe.getState());
    }
    @Test
    public void Cmodif(){
        Long categoryId = 1103l;
        String name = "模拟经营游戏";
        ProductCategoryExecution pe = productCategoryService.modifProductCategory(categoryId,name);
        assertEquals(ProductCategoryStateEnum.SUCCESS.getState(),pe.getState());
    }
    @Test
    public void Dremove(){
        Long categoryId = 1103l;
        ProductCategoryExecution pe = productCategoryService.removeProductCategory(categoryId);
        assertEquals(ProductCategoryStateEnum.SUCCESS.getState(),pe.getState());
    }
}
