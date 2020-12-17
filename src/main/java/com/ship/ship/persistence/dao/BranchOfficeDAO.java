package com.ship.ship.persistence.dao;

import com.ship.ship.exceptions.ShipException;
import com.ship.ship.persistence.model.BranchOffice;
import com.ship.ship.persistence.repository.BranchOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BranchOfficeDAO {

    @Autowired
    private BranchOfficeRepository repository;

    public List<BranchOffice> getBranchOffice(){
        List<BranchOffice> branchOffices = new ArrayList<>();
        this.repository.findAll().forEach(branchOffice -> branchOffices.add(branchOffice));
        return branchOffices;
    }

    public BranchOffice getBranchOfficeById(Integer id) throws ShipException {
        return this.repository.findById(id).orElseThrow(() ->
        {
            String msg = String.format("The branchOffice id %s does not exist", id.toString());
            return new ShipException(msg);
        });
    }

    public BranchOffice saveBranchOffice(BranchOffice branchOffice) throws ShipException {
        return this.repository.save(branchOffice);
    }

    public List<BranchOffice> saveBranchOfficees(List<BranchOffice> branchOffices) throws ShipException {
        List<BranchOffice> finalList= new ArrayList<>();
        this.repository.saveAll(branchOffices).forEach(branchOffice -> {
            finalList.add(branchOffice);
        });
        return finalList;
    }

    public void deleteBranchOffice(BranchOffice branchOffice){
        this.repository.delete(branchOffice);
    }

    public BranchOffice updateBranchOffice(BranchOffice branchOffice) throws ShipException {
        if(branchOffice.getId()!=null){
            return this.repository.save(branchOffice);
        }else{
            String msg = String.format("Cannot update a branchOffice without an Id");
            throw new ShipException(msg);
        }
    }
}
