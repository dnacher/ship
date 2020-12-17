package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.BranchOfficeService;
import com.ship.ship.persistence.model.BranchOffice;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/private/branch_offices")
public class BranchOfficeController {

    private final BranchOfficeService branchOfficeService;

    public BranchOfficeController(BranchOfficeService branchOfficeService){
        this.branchOfficeService = branchOfficeService;
    }

    @PostMapping(value = "/")
    public BranchOffice saveBranchOffice(@RequestBody BranchOffice branchOffice){
        return this.branchOfficeService.saveBranchOffice(branchOffice);
    }

    @PostMapping(value = "/mul")
    public List<BranchOffice> saveBranchOfficees(@RequestBody List<BranchOffice> branchOfficees){
        List<BranchOffice> finalList = new ArrayList<>();
        branchOfficees.forEach(branchOffice -> {
            finalList.add(this.branchOfficeService.saveBranchOffice(branchOffice));
        });
        return finalList;
    }

    @PutMapping(value = "/{id}")
    public BranchOffice updateBranchOffice(@PathVariable Integer id, @RequestBody BranchOffice branchOffice){
        String msg = String.format("The BranchOffice Id %s is different from the Url Id",branchOffice.getId());
        Utils.validateUrlIdEqualsBodyId(id,branchOffice.getId(),msg);
        return this.branchOfficeService.updateBranchOffice(branchOffice);
    }

    @PutMapping(value = "/mul")
    public List<BranchOffice> updateBranchOffice(@RequestBody List<BranchOffice> branchOfficees){
        List<BranchOffice> finalList = new ArrayList<>();
        branchOfficees.forEach(branchOffice -> {
            finalList.add(this.branchOfficeService.updateBranchOffice(branchOffice));
        });
        return finalList;
    }

    @GetMapping(value = "/")
    public List<BranchOffice> getBranchOffice(){
        return this.branchOfficeService.getBranchOffice();
    }

    @GetMapping(value = "/{id}")
    public BranchOffice getBranchOfficeById(@PathVariable Integer id){
        return this.branchOfficeService.getBranchOfficeById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBranchOffice(@PathVariable Integer id, BranchOffice branchOffice){
        String msg = String.format("The BranchOffice Id %s is different from the Url Id",branchOffice.getId());
        Utils.validateUrlIdEqualsBodyId(id,branchOffice.getId(),msg);
        this.branchOfficeService.deleteBranchOffice(branchOffice);
    }
}
