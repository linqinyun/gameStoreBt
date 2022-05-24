package com.lin.gamestroe.web.stroe.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.gamestroe.dto.ProductCategoryExecution;
import com.lin.gamestroe.entity.ProductCategory;
import com.lin.gamestroe.enums.ProductCategoryStateEnum;
import com.lin.gamestroe.exceptions.ProductCategoryOperationException;
import com.lin.gamestroe.service.ProductCategoryService;
import com.lin.gamestroe.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/productcategory")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping(value = "/productcategorylist", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> productCategoryList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<ProductCategory> productCategoryList = productCategoryService.getProductCategoryList();
        modelMap.put("productCategoryList", productCategoryList);
        modelMap.put("success", true);
        return modelMap;
    }

    @RequestMapping(value = "/addproductcategory", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> addProductCategory(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();
        ProductCategory productCategory = null;
        try {
            String productCategoryStr = HttpServletRequestUtil.getString(request, "productCategoryStr");
            productCategory = mapper.readValue(productCategoryStr, ProductCategory.class);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        if (productCategory != null && productCategory.getCategoryId() != null && productCategory.getParentCategoryId() != null && productCategory.getName() != null) {
            try {
                ProductCategoryExecution pe = productCategoryService.bindProductCategory(productCategory);
                if (pe.getState() == ProductCategoryStateEnum.FAILED.getState()) {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", pe.getStateInfo());
                } else {
                    modelMap.put("success", true);
                }
            } catch (ProductCategoryOperationException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
            }
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "信息缺失");
        }
        return modelMap;
    }

    @RequestMapping(value = "/modifproductcategory",method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> modifProductCategory(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Long categoryId = HttpServletRequestUtil.getLong(request, "categoryId");
        String name = HttpServletRequestUtil.getString(request, "name");
        if (categoryId != null && name != null) {
            try {
                ProductCategoryExecution pe = productCategoryService.modifProductCategory(categoryId,name);
                if (pe.getState() == ProductCategoryStateEnum.FAILED.getState()) {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", pe.getStateInfo());
                } else {
                    modelMap.put("success", true);
                }
            } catch (ProductCategoryOperationException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
            }
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "信息缺失");
        }
        return modelMap;
    }
    @RequestMapping(value = "/removeproductcategory",method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> removeProductCategory(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Long categoryId = HttpServletRequestUtil.getLong(request, "categoryId");
        if (categoryId != null) {
            try {
                ProductCategoryExecution pe = productCategoryService.removeProductCategory(categoryId);
                if (pe.getState() == ProductCategoryStateEnum.FAILED.getState()) {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", pe.getStateInfo());
                } else {
                    modelMap.put("success", true);
                }
            } catch (ProductCategoryOperationException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
            }
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "信息缺失");
        }
        return modelMap;
    }
}
