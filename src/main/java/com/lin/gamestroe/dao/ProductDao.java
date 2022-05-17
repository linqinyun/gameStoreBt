package com.lin.gamestroe.dao;

import com.lin.gamestroe.entity.Product;
import com.lin.gamestroe.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ProductDao {
    /**
     * 产品列表
     *
     * @return
     */
    List<Product> queryProductList();

    /**
     * 产品数量
     *
     * @return
     */
    int queryproductCount();

    /**
     * 添加产品
     *
     * @param product
     * @return
     */
    int insertProduct(Product product);

    /**
     * 修改产品
     *
     * @param product
     * @return
     */
    int updateProduct(Product product);

    /**
     * 删除产品分类
     *
     * @param productId
     * @return
     */
    int deleteProduct(@Param("productId") long productId);
}
