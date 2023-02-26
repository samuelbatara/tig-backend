package com.tigapanah.product.controller;

import com.tigapanah.product.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "tigpro")
public interface ProductDataController {
  @GetMapping("/product/exists/{id}")
  boolean isProductExists(@PathVariable long id) throws Exception;

  @GetMapping("/product/{id}")
  Product getProduct(@PathVariable long id) throws Exception;

  @PostMapping("/product")
  boolean addProduct(@RequestBody Product product) throws Exception;

  @PutMapping("/product")
  boolean updateProduct(@RequestBody Product product) throws Exception;

  @DeleteMapping("/product/{id}")
  boolean deleteProduct(@PathVariable long id) throws Exception;
}
