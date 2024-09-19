package com.shoppingmall.controller;

import com.shoppingmall.model.Shop;
import com.shoppingmall.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @PostMapping("/create")
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        Shop createdShop = shopService.createShop(shop);
        return ResponseEntity.ok(createdShop);
    }

    @GetMapping
    public List<Shop> getAllShops() {
        return shopService.getAllShops();
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<String> approveShop(@PathVariable Long id) {
        shopService.approveShop(id);
        return ResponseEntity.ok("Shop approved");
    }
}
