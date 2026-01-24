package com.erp.Ecommeres.wishlist.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.erp.Ecommeres.wishlist.entity.Wishlist;
import com.erp.Ecommeres.wishlist.service.WishlistService;

@RestController
@RequestMapping("/api/wishlist")
@CrossOrigin(origins = "*")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    // ADD TO WISHLIST
    @PostMapping (consumes = "application/json")
    public ResponseEntity<Wishlist> addWishlist(@RequestBody Wishlist wishlist) {
        System.out.println("IN CONTROLLER: " + wishlist.getProductName());
        Wishlist saved = wishlistService.addToWishlist(wishlist);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    // GET MY WISHLIST
    @GetMapping("/{userId}")
    public ResponseEntity<List<Wishlist>> getWishlist(@PathVariable Long userId) {
        return ResponseEntity.ok(wishlistService.getWishlist(userId));
    }

    // DELETE WISHLIST ITEM
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWishlist(@PathVariable Long id) {
        wishlistService.deleteWishlistItem(id);
        return ResponseEntity.ok("Wishlist item removed");
    }
}
