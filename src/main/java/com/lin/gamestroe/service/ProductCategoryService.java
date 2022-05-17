package com.lin.gamestroe.service;

import com.lin.gamestroe.dto.ProductCategoryExecution;
import com.lin.gamestroe.entity.ProductCategory;
import com.lin.gamestroe.exceptions.ProductCategoryOperationException;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> getProductCategoryList();

    ProductCategoryExecution bindProductCategory(ProductCategory productCategory) throws ProductCategoryOperationException;

    ProductCategoryExecution modifProductCategory(Long categoryId, String name) throws ProductCategoryOperationException;

    ProductCategoryExecution removeProductCategory(Long categoryId) throws ProductCategoryOperationException;
}
