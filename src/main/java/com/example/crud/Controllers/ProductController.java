package com.example.crud.Controllers;

import com.example.crud.Entities.Product;
import com.example.crud.Services.Product.ProductService;
import com.example.crud.Services.Rank.RankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//RestController don't redirect to view
@Controller
public class ProductController {
    private ProductService productService;
    private RankService rankService;

    public ProductController(ProductService productService, RankService rankService) {
        this.productService = productService;
        this.rankService = rankService;
    }

    @RequestMapping("product/{Id}")
    public ModelAndView showProductById(@PathVariable Long Id, Model model) {
        return new ModelAndView("product/showProductById", "product", productService.getProductById(Id));
//        model.addAttribute("product", productService.getProductById(Id));
//        return "showProductById";
    }

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product/products";
    }

    //    create product page
    @RequestMapping("product/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/productForm";
    }

    //    after create product page   post:(non idempotent)  put: idempotent
    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product) {
        rankService.addScore(product.getName(), product.getPrice());
        productService.saveProduct(product);
        return "redirect:/product/" + product.getId();
    }

    @RequestMapping("product/edit/{Id}")
    public String edit(@PathVariable Long Id, Model model) {
        model.addAttribute("product", productService.getProductById(Id));
        return "/product/productForm";
    }

    @RequestMapping("product/delete/{Id}")
    public String delete(@PathVariable Long Id) {
        Product product = productService.getProductById(Id);
        rankService.removeScore(product.getName());

        productService.deleteProduct(Id);
        //redirect to index(home page)
        return "redirect:/";
    }

}
