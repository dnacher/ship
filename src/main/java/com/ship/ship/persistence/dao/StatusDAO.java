package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.Status;
import com.ship.ship.persistence.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StatusDAO {

    @Autowired
    private StatusRepository repository;

    public List<Status> getStatus(){
        List<Status> statusList = new ArrayList<>();
        this.repository.findAll().forEach(status -> statusList.add(status));
        return statusList;
    }

    public Status getStatusById(Integer id) throws ShipException {
        return this.repository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The status id %s does not exist", id.toString());
            return new ShipException(msg);
        });
    }

    public Status saveStatus(Status status) throws ShipException {
        return this.repository.save(status);
    }

    public List<Status> saveStatuses(List<Status> statusList) throws ShipException {
        List<Status> finalList= new ArrayList<>();
        this.repository.saveAll(statusList).forEach(status -> {
            finalList.add(status);
        });
        return finalList;
    }

    public void deleteStatus(Status status){
        this.repository.delete(status);
    }

    public Status updateStatus(Status status) throws ShipException {
        if(status.getId()!=null){
            return this.repository.save(status);
        }else{
            String msg = String.format("Cannot update a status without an Id");
            throw new ShipException(msg);
        }
    }
}
