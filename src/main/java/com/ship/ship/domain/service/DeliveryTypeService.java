package com.ship.ship.domain.service;

import com.ship.ship.persistence.dao.DeliveryTypeDAO;
import com.ship.ship.persistence.model.DeliveryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DeliveryTypeService {

    @Autowired
    private DeliveryTypeDAO deliveryTypeDAO;

    public List<DeliveryType> getDeliveryType(){
        return deliveryTypeDAO.getDeliveryType();
    }

    public DeliveryType getDeliveryTypeById(Integer id){
        return deliveryTypeDAO.getDeliveryTypeById(id);
    }

    public DeliveryType saveDeliveryType(DeliveryType deliveryType){
        return deliveryTypeDAO.saveDeliveryType(deliveryType);
    }

    public DeliveryType updateDeliveryType(DeliveryType deliveryType){
        return deliveryTypeDAO.updateDeliveryType(deliveryType);
    }

    public void deleteDeliveryType(DeliveryType deliveryType){
        deliveryTypeDAO.deleteDeliveryType(deliveryType);
    }
}
