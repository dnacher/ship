package com.ship.ship.domain.service;

import com.ship.ship.persistence.dao.AddressDAO;
import com.ship.ship.persistence.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddressService {

    @Autowired
    private AddressDAO addressDAO;

    public List<Address> getAddress(){
        return addressDAO.getAddress();
    }

    public Address getAddressById(Integer id){
        return addressDAO.getAddressById(id);
    }

    public Address saveAddress(Address address){
        return addressDAO.saveAddress(address);
    }

    public Address updateAddress(Address address){
        return addressDAO.updateAddress(address);
    }

    public void deleteAddress(Address address){
        addressDAO.deleteAddress(address);
    }



}
