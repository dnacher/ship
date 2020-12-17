package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.StatusService;
import com.ship.ship.persistence.model.Status;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/private/status")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService){
        this.statusService = statusService;
    }

    @PostMapping(value = "/")
    public Status saveStatus(@RequestBody Status status){
        return this.statusService.saveStatus(status);
    }

    @PostMapping(value = "/mul")
    public List<Status> saveStatuses(@RequestBody List<Status> statuses){
        List<Status> finalList = new ArrayList<>();
        statuses.forEach(status -> {
            finalList.add(this.statusService.saveStatus(status));
        });
        return finalList;
    }

    @PutMapping(value = "/{id}")
    public Status updateStatus(@PathVariable Integer id, @RequestBody Status status){
        String msg = String.format("The Status Id %s is different from the Url Id",status.getId());
        Utils.validateUrlIdEqualsBodyId(id,status.getId(),msg);
        return this.statusService.updateStatus(status);
    }

    @PutMapping(value = "/mul")
    public List<Status> updateStatus(@RequestBody List<Status> statuses){
        List<Status> finalList = new ArrayList<>();
        statuses.forEach(status -> {
            finalList.add(this.statusService.updateStatus(status));
        });
        return finalList;
    }

    @GetMapping(value = "/")
    public List<Status> getStatus(){
        return this.statusService.getStatus();
    }

    @GetMapping(value = "/{id}")
    public Status getStatusById(@PathVariable Integer id){
        return this.statusService.getStatusById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStatus(@PathVariable Integer id, Status status){
        String msg = String.format("The Status Id %s is different from the Url Id",status.getId());
        Utils.validateUrlIdEqualsBodyId(id,status.getId(),msg);
        this.statusService.deleteStatus(status);
    }
}
