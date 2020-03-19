package com.product.microservices.productservice.feignProxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.product.microservices.productservice.bean.ProductPricePromotionDetails;


@FeignClient("inventory-service")
@RibbonClient(name = "inventory-service")
public interface InventoryServiceProxy {
	@PutMapping("/inventory-service/updateInventory/{quantity}/{productId}")
	public ProductPricePromotionDetails saveInventoryDetails(@PathVariable Integer quantity,@PathVariable String productId);

	@PostMapping("/inventory-service/saveInventory/{id}/{productId}/{productCategory}/{quantity}")
	public ProductPricePromotionDetails saveInventoryData(@PathVariable String id,
			                                              @PathVariable String productId,
			                                              @PathVariable String productCategory,
		                                                  @PathVariable Integer quantity
			     );	
}
