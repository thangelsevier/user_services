package com.thangdtran.user_services.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="product-services", url = "http://localhost:8080")
public interface ProductFeignClient {
    @GetMapping(path = "/product/{product_id}")
    String getProductInfo(@PathVariable("product_id") String productId);

    @PostMapping(path="/product/{product_id}/name/{product_name}")
    boolean updateProductName(@PathVariable("product_id") String productId,
                              @PathVariable("product_name") String product_name);
}
