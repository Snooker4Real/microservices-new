package fr.cindanojonathan.inventoryservice.controller;

import fr.cindanojonathan.inventoryservice.dto.InventoryResponse;
import fr.cindanojonathan.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

//    http://localhost:8082/api/inventory/iphone-14,iphone-14-pro

//    http://localhost:8082/api/inventory?sku-code=iphone-14&sku-code=iphone-14-pro
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam("sku-code") List<String> skuCode) {
        return inventoryService.isInStock(skuCode);
    }
}
