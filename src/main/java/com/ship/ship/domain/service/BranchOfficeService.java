package com.ship.ship.domain.service;

import com.ship.ship.persistence.dao.BranchOfficeDAO;
import com.ship.ship.persistence.model.BranchOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BranchOfficeService {
    
    @Autowired
    private BranchOfficeDAO branchOfficeDAO;

    public List<BranchOffice> getBranchOffice(){
        return branchOfficeDAO.getBranchOffice();
    }

    public BranchOffice getBranchOfficeById(Integer id){
        return branchOfficeDAO.getBranchOfficeById(id);
    }

    public BranchOffice saveBranchOffice(BranchOffice branchOffice){
        return branchOfficeDAO.saveBranchOffice(branchOffice);
    }

    public BranchOffice updateBranchOffice(BranchOffice branchOffice){
        return branchOfficeDAO.updateBranchOffice(branchOffice);
    }

    public void deleteBranchOffice(BranchOffice branchOffice){
        branchOfficeDAO.deleteBranchOffice(branchOffice);
    }
}
