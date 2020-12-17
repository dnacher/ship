package com.ship.ship.domain.service;

import com.ship.ship.persistence.dao.NeighborhoodDAO;
import com.ship.ship.persistence.model.Neighborhood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NeighborhoodService {

    @Autowired
    private NeighborhoodDAO neighborhoodDAO;

    public List<Neighborhood> getNeighborhood(){
        return neighborhoodDAO.getNeighborhood();
    }

    public Neighborhood getNeighborhoodById(Integer id){
        return neighborhoodDAO.getNeighborhoodById(id);
    }

    public Neighborhood saveNeighborhood(Neighborhood neighborhood){
        return neighborhoodDAO.saveNeighborhood(neighborhood);
    }

    public Neighborhood updateNeighborhood(Neighborhood neighborhood){
        return neighborhoodDAO.updateNeighborhood(neighborhood);
    }

    public void deleteNeighborhood(Neighborhood neighborhood){
        neighborhoodDAO.deleteNeighborhood(neighborhood);
    }
}
