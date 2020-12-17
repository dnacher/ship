package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.UserTypeService;
import com.ship.ship.persistence.model.UserType;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/private/user_types")
public class UserTypeController {

    private final UserTypeService userTypeService;

    public UserTypeController(UserTypeService userTypeService){
        this.userTypeService = userTypeService;
    }

    @PostMapping(value = "/")
    public UserType saveUserType(@RequestBody UserType userType){
        return this.userTypeService.saveUserType(userType);
    }

    @PostMapping(value = "/mul")
    public List<UserType> saveUserTypees(@RequestBody List<UserType> userTypees){
        List<UserType> finalList = new ArrayList<>();
        userTypees.forEach(userType -> {
            finalList.add(this.userTypeService.saveUserType(userType));
        });
        return finalList;
    }

    @PutMapping(value = "/{id}")
    public UserType updateUserType(@PathVariable Integer id, @RequestBody UserType userType){
        String msg = String.format("The UserType Id %s is different from the Url Id",userType.getId());
        Utils.validateUrlIdEqualsBodyId(id,userType.getId(),msg);
        return this.userTypeService.updateUserType(userType);
    }

    @PutMapping(value = "/mul")
    public List<UserType> updateUserType(@RequestBody List<UserType> userTypees){
        List<UserType> finalList = new ArrayList<>();
        userTypees.forEach(userType -> {
            finalList.add(this.userTypeService.updateUserType(userType));
        });
        return finalList;
    }

    @GetMapping(value = "/")
    public List<UserType> getUserType(){
        return this.userTypeService.getUserType();
    }

    @GetMapping(value = "/{id}")
    public UserType getUserTypeById(@PathVariable Integer id){
        return this.userTypeService.getUserTypeById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUserType(@PathVariable Integer id, UserType userType){
        String msg = String.format("The UserType Id %s is different from the Url Id",userType.getId());
        Utils.validateUrlIdEqualsBodyId(id,userType.getId(),msg);
        this.userTypeService.deleteUserType(userType);
    }
}
