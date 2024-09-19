package com.shoppingmall.service;

import com.shoppingmall.model.Shop;
import com.shoppingmall.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    public Shop createShop(Shop shop) {
        shop.setStatus("PENDING");
        return shopRepository.save(shop);
    }

    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    public Shop approveShop(Long id) {
        Shop shop = shopRepository.findById(id).orElseThrow();
        shop.setStatus("OPEN");
        return shopRepository.save(shop);
    }
}
