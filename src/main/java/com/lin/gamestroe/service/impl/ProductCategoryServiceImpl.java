package com.lin.gamestroe.service.impl;

import com.lin.gamestroe.dao.ProductCategoryDao;
import com.lin.gamestroe.dto.ProductCategoryExecution;
import com.lin.gamestroe.entity.ProductCategory;
import com.lin.gamestroe.enums.ProductCategoryStateEnum;
import com.lin.gamestroe.exceptions.ProductCategoryOperationException;
import com.lin.gamestroe.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> getProductCategoryList() {
        return productCategoryDao.queryProductCategoryList();
    }

    @Override
    @Transactional
    public ProductCategoryExecution bindProductCategory(ProductCategory productCategory) throws ProductCategoryOperationException {
        if (productCategory == null) {
            return new ProductCategoryExecution(ProductCategoryStateEnum.FAILED);
        }
        productCategory.setCreateTime(new Date());
        productCategory.setUpdateTime(new Date());
        try {
            int effectedNum = productCategoryDao.insertProductCategory(productCategory);
            if (effectedNum <= 0) {
                throw new ProductCategoryOperationException("新增失败");
            } else {
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }
        } catch (Exception e) {
            throw new ProductCategoryOperationException("insertProductCategory error: " + e.getMessage());
        }

    }

    @Override
    @Transactional
    public ProductCategoryExecution modifProductCategory(Long categoryId, String name) throws ProductCategoryOperationException {
        if (categoryId == null || name == null) {
            return new ProductCategoryExecution(ProductCategoryStateEnum.FAILED);
        }
        try {
            int effectedNum = productCategoryDao.updateProductCategory(categoryId, name, new Date());
            if (effectedNum <= 0) {
                throw new ProductCategoryOperationException("修改失败");
            } else {
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }
        } catch (Exception e) {
            throw new ProductCategoryOperationException("insertProductCategory error: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public ProductCategoryExecution removeProductCategory(Long categoryId) throws ProductCategoryOperationException {
        if (categoryId == null) {
            return new ProductCategoryExecution(ProductCategoryStateEnum.FAILED);
        }
        try {
            int effectedNum = productCategoryDao.deleteProductCategory(categoryId);
            if (effectedNum <= 0) {
                throw new ProductCategoryOperationException("删除失败");
            } else {
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }
        } catch (Exception e) {
            throw new ProductCategoryOperationException("insertProductCategory error: " + e.getMessage());
        }
    }
}
