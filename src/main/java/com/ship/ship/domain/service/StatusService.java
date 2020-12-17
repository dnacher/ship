package com.ship.ship.domain.service;

import com.ship.ship.persistence.dao.StatusDAO;
import com.ship.ship.persistence.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StatusService {

    @Autowired
    private StatusDAO statusDAO;

    public List<Status> getStatus(){
        return statusDAO.getStatus();
    }

    public Status getStatusById(Integer id){
        return statusDAO.getStatusById(id);
    }

    public Status saveStatus(Status status){
        return statusDAO.saveStatus(status);
    }

    public Status updateStatus(Status status){
        return statusDAO.updateStatus(status);
    }

    public void deleteStatus(Status status){
        statusDAO.deleteStatus(status);
    }
}
