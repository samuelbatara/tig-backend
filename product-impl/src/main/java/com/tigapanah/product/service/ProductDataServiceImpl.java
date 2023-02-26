package com.tigapanah.product.service;

import com.tigapanah.product.model.Product;
import com.tigapanah.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductDataServiceImpl implements ProductDataService {

  private ProductRepository productRepository;
  private Logger logger = LoggerFactory.getLogger(ProductDataServiceImpl.class);

  public ProductDataServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public boolean isProductExists(long id) throws Exception {
    boolean result = false;
    try {
      result = productRepository.existsById(id);
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to check a product with id=%s", id), e
      );
    }

    return result;
  }

  @Override
  public Product getProduct(long id) throws Exception {
    Optional<Product> optionalProduct = null;
    try {
      optionalProduct = productRepository.findById(id);
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to find a product with id=%s", id), e
      );
    }

    if (optionalProduct.isEmpty()) {
      logger.error("Product is empty with id=%s{}", id);
      return null;
    }

    return optionalProduct.get();
  }

  @Override
  public boolean addProduct(Product product) throws Exception {
    try {
      productRepository.save(product);
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to save a product=%s", product.toString()), e
      );
    }

    return true;
  }

  @Override
  public boolean updateProduct(Product product) throws Exception {
    if (Long.valueOf(product.getId()) != null) {
      logger.error("Can't update product because id is not defined.");
      return false;
    }

    Optional<Product> optionalProduct = null;
    try {
      optionalProduct = productRepository.findById(product.getId());
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to find a product=%s", product.toString()), e
      );
    }

    if (optionalProduct.isEmpty()) {
      throw new Exception(
          String.format("Product with id=%s is not registered", product.getId())
      );
    }

    Product retreivedProduct = optionalProduct.get();
    if (product.getName() == null) {
      retreivedProduct.setName(product.getName());
    }
    if (product.getPrice() == null) {
      retreivedProduct.setPrice(product.getPrice());
    }

    try {
      productRepository.save(retreivedProduct);
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to save a product=%s", product.toString()), e
      );
    }

    return true;
  }

  @Override
  public boolean deleteProduct(long id) throws Exception {
    try {
      productRepository.deleteById(id);
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to delete product with id=%s", id), e
      );
    }

    return true;
  }
}
