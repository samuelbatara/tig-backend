package com.tigapanah.product.service;

import com.tigapanah.product.model.Product;

public interface ProductDataService {
  boolean isProductExists(long id) throws Exception;
  Product getProduct(long id) throws Exception;
  boolean addProduct(Product product) throws Exception;
  boolean updateProduct(Product product) throws Exception;
  boolean deleteProduct(long id) throws Exception;
}
