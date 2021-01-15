package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.AddressService;
import com.ship.ship.persistence.model.Address;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/public/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @PostMapping(value = "/")
    public Address saveAddress(@RequestBody Address address){
        return this.addressService.saveAddress(address);
    }

    @PostMapping(value = "/mul")
    public List<Address> saveAddresses(@RequestBody List<Address> addresses){
        List<Address> finalList = new ArrayList<>();
        addresses.forEach(address -> {
            finalList.add(this.addressService.saveAddress(address));
        });
        return finalList;
    }

    @PutMapping(value = "/{id}")
    public Address updateAddress(@PathVariable Integer id, @RequestBody Address address){
        String msg = String.format("The Address Id %s is different from the Url Id",address.getId());
        Utils.validateUrlIdEqualsBodyId(id,address.getId(),msg);
        return this.addressService.updateAddress(address);
    }

    @PutMapping(value = "/mul")
    public List<Address> updateAddress(@RequestBody List<Address> addresses){
        List<Address> finalList = new ArrayList<>();
        addresses.forEach(address -> {
            finalList.add(this.addressService.updateAddress(address));
        });
        return finalList;
    }

    @GetMapping(value = "/")
    public List<Address> getAddress(){
        return this.addressService.getAddress();
    }

    @GetMapping(value = "/{id}")
    public Address getAddressById(@PathVariable Integer id){
        return this.addressService.getAddressById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAddress(@PathVariable Integer id, Address address){
        String msg = String.format("The Address Id %s is different from the Url Id",address.getId());
        Utils.validateUrlIdEqualsBodyId(id,address.getId(),msg);
        this.addressService.deleteAddress(address);
    }
}
