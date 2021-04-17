package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.UserService;
import com.ship.ship.persistence.model.User;
import com.ship.ship.utils.Utils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/private/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(value = "/")
  public User saveUser(@RequestBody User user) {
    return this.userService.registerUser(user);
  }

  @GetMapping(value = "/")
  public List<User> getUser() {
    return this.userService.getUser();
  }

  @GetMapping(value = "/{id}")
  public User getUserById(@PathVariable Integer id) {
    return this.userService.getUserById(id);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteUser(@PathVariable Integer id, User user) {
    String msg = String.format("The User Id %s is different from the Url Id", user.getId());
    Utils.validateUrlIdEqualsBodyId(id, user.getId(), msg);
    this.userService.deleteUser(user);
  }
}
