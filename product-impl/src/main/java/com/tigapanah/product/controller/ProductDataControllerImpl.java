package com.tigapanah.product.controller;

import com.tigapanah.product.model.Product;
import com.tigapanah.product.service.ProductDataService;
import com.tigapanah.product.service.ProductDataServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductDataControllerImpl implements ProductDataController {

  private ProductDataService productDataService;

  public ProductDataControllerImpl(ProductDataServiceImpl productDataService) {
    this.productDataService = productDataService;
  }

  @Override
  public boolean isProductExists(long id) throws Exception{
    return productDataService.isProductExists(id);
  }

  @Override
  public Product getProduct(long id) throws Exception{
    return productDataService.getProduct(id);
  }

  @Override
  public boolean addProduct(Product product) throws Exception{
    return productDataService.addProduct(product);
  }

  @Override
  public boolean updateProduct(Product product) throws Exception{
    return productDataService.updateProduct(product);
  }

  @Override
  public boolean deleteProduct(long id) throws Exception{
    return productDataService.deleteProduct(id);
  }
}
