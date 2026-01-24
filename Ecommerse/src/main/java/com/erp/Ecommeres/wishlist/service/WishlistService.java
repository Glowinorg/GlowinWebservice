package com.erp.Ecommeres.wishlist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.erp.Ecommeres.wishlist.entity.Wishlist;
import com.erp.Ecommeres.wishlist.repo.WishlistRepository;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    // ADD TO WISHLIST
    public Wishlist addToWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    // GET USER WISHLIST
    public List<Wishlist> getWishlist(Long userId) {
        return wishlistRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    // DELETE WISHLIST ITEM
    public void deleteWishlistItem(Long id) {
        wishlistRepository.deleteById(id);
    }
}
