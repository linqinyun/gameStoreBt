package com.lin.gamestroe.dao;

import com.lin.gamestroe.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ProductCategoryDao {
    /**
     * 产品分类列表
     * @return
     */
    List<ProductCategory> queryProductCategoryList();

    /**
     * 添加产品分类
     * @param productCategory
     * @return
     */
    int insertProductCategory(ProductCategory productCategory);

    /**
     * 修改产品分类
     * @param categoryId
     * @param name
     * @param updateTime
     * @return
     */
    int updateProductCategory(@Param("categoryId")Long categoryId, @Param("name")String name, @Param("updateTime")Date updateTime);

    /**
     * 删除产品分类
     * @param categoryId
     * @return
     */
    int deleteProductCategory(@Param("categoryId") long categoryId);
}
