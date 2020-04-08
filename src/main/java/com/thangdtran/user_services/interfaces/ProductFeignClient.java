package com.thangdtran.user_services.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product-services", url = "http://localhost:8080")
public interface ProductFeignClient {
    @GetMapping(path = "/product/{product_id}")
    String getProductInfo(@PathVariable("product_id") String productId);
}
