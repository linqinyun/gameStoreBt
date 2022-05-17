package com.lin.gamestroe.service;

import com.lin.gamestroe.dto.ProductExecution;
import com.lin.gamestroe.entity.Product;
import com.lin.gamestroe.exceptions.ProductOperationException;

import java.util.List;

public interface ProductService {
    ProductExecution getProductList();

    ProductExecution bindProduct(Product product) throws ProductOperationException;

    ProductExecution modifProduct(Product product) throws ProductOperationException;

    ProductExecution removeProduct(Long productId) throws ProductOperationException;
}
