package com.erp.Ecommeres.address.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.erp.Ecommeres.address.entity.Address;
import com.erp.Ecommeres.address.service.AddressService;

@RestController
@RequestMapping("/api/address")
@CrossOrigin(origins = "*")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // SAVE ADDRESS
    @PostMapping
    public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
        return ResponseEntity.ok(addressService.saveAddress(address));
    }

    // GET USER ADDRESSES
    @GetMapping("/{userId}")
    public ResponseEntity<List<Address>> getAddresses(@PathVariable Long userId) {
        return ResponseEntity.ok(addressService.getAddresses(userId));
    }

    // DELETE ADDRESS
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok("Address deleted successfully");
    }
}
