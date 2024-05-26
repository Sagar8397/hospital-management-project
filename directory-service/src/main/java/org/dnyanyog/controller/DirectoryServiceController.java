package org.dnyanyog.controller;

import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectoryServiceController {

  @Autowired UserServiceImpl userService;

  @PostMapping(
      path = "/api/v1/user/add",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public UserResponse addUser(@RequestBody UserRequest userRequest) {
    return userService.addUser(userRequest);
  }

  @GetMapping(path = "/api/v1/user/search/{user_id}")
  public UserResponse getSingleUser(@PathVariable Long user_id) {
    return userService.getSingleUser(user_id);
  }
}
