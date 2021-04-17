package com.ship.ship.endpoint.controller;

import com.ship.ship.domain.service.UserServiceImpl;
import com.ship.ship.dto.UserDTO;
import com.ship.ship.jwt.JWTRequest;
import com.ship.ship.jwt.JWTResponse;
import com.ship.ship.persistence.model.User;
import com.ship.ship.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class MainController {

  private final UserServiceImpl userService;
  private final JwtUtils jwtUtils;
  private final String VERSION = "1.3.0";

  @Autowired
  public MainController(UserServiceImpl userService, JwtUtils jwtUtils) {
    this.userService = userService;
    this.jwtUtils = jwtUtils;
  }

  @GetMapping("/public/")
  public String main() {
    return "Ship v " + VERSION;
  }

  @PostMapping("/public/register")
  public User register(@RequestBody User user) {
    return userService.registerUser(user);
  }

  @PostMapping("/public/login")
  public JWTResponse login(@RequestBody JWTRequest jwtRequest) {
    UserDTO user = getUserDTO(jwtRequest.getUser());
    if (user != null) {
      JWTResponse jwtResponse = jwtUtils.generateJWTToken(user);
      return jwtResponse;
    } else {
      return new JWTResponse("Password or user incorrect", null, null);
    }
  }

  private UserDTO getUserDTO(UserDTO user) {
    return userService.Login(user);
  }
}
