package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.DeliveryType;
import com.ship.ship.persistence.repository.DeliveryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeliveryTypeDAO {

    @Autowired
    private DeliveryTypeRepository repository;

    public List<DeliveryType> getDeliveryType(){
        List<DeliveryType> deliveryTypes = new ArrayList<>();
        this.repository.findAll().forEach(deliveryType -> deliveryTypes.add(deliveryType));
        return deliveryTypes;
    }

    public DeliveryType getDeliveryTypeById(Integer id) throws ShipException {
        return this.repository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The deliveryType id %s does not exist", id.toString());
            return new ShipException(msg);
        });
    }

    public DeliveryType saveDeliveryType(DeliveryType deliveryType) throws ShipException {
        return this.repository.save(deliveryType);
    }

    public List<DeliveryType> saveDeliveryTypes(List<DeliveryType> deliveryTypes) throws ShipException {
        List<DeliveryType> finalList= new ArrayList<>();
        this.repository.saveAll(deliveryTypes).forEach(deliveryType -> {
            finalList.add(deliveryType);
        });
        return finalList;
    }

    public void deleteDeliveryType(DeliveryType deliveryType){
        this.repository.delete(deliveryType);
    }

    public DeliveryType updateDeliveryType(DeliveryType deliveryType) throws ShipException {
        if(deliveryType.getId()!=null){
            return this.repository.save(deliveryType);
        }else{
            String msg = String.format("Cannot update a deliveryType without an Id");
            throw new ShipException(msg);
        }
    }
}