package controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import service.CategoryService;
import service.ProductService;
import entity.Category;
import entity.Product;

@RestController
@RequestMapping("/product")
@Api(value = "productController")
public class ProductController {

    private CategoryService cs;
    
    private ProductService ps;

    @RequestMapping(value = "/{id}/", method = RequestMethod.GET)
    @ApiOperation(value = "return product by category", response = Boolean.class, notes = "Return product")
    @ApiResponse(code = 200, message = "product was returned successfully")
    public @ResponseBody List<Product> getProductByCategory(@QueryParam("idCategory") Iterable<Integer> idCategory) {

        Category category = (Category) cs.findById(idCategory);
        List<Product> products = ps.findByCategory(category);
        return products;

    }

    @RequestMapping(value = "/{name]", method = RequestMethod.GET)
    @ApiOperation(value = "return product by name", response = Boolean.class, notes = "Return product")
    @ApiResponse(code = 200, message = "product was returned successfully")
    public List<Product> getProductByName(@QueryParam("name") String name) {

        return ps.getProductByName(name);
    }

}