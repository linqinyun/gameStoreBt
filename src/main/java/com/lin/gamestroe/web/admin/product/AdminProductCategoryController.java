package com.lin.gamestroe.web.admin.product;

import com.lin.gamestroe.entity.ProductCategory;
import com.lin.gamestroe.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/pcate")
public class AdminProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView categoryList(){
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/pcate/404");
        List<ProductCategory> productCategoryList = productCategoryService.getProductCategoryList();
        modelAndView.addObject("test","123");
        modelAndView.addObject("list",productCategoryList);
        return modelAndView;
    }
    @RequestMapping(value = "/404")
    public String fount(){
        return "/test/demo";
    }
}
