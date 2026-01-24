package com.erp.Ecommeres.address.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.erp.Ecommeres.address.entity.Address;
import com.erp.Ecommeres.address.repo.AddressRepository;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // SAVE ADDRESS
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    // GET USER ADDRESSES
    public List<Address> getAddresses(Long userId) {
        return addressRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    // DELETE ADDRESS
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
