package com.tigapanah.user.controller;

import com.tigapanah.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "tiguse")
public interface UserDataController {
  @GetMapping("/user/exists/{id}")
  boolean isUserExists(@PathVariable("id") long id) throws Exception;
  @GetMapping("/user/{id}")
  User getUser(@PathVariable("id") long id) throws Exception;

  @PostMapping("/user")
  boolean addUser(@RequestBody User user) throws Exception;

  @PutMapping("/user")
  boolean updateUser(@RequestBody User user) throws Exception;

  @DeleteMapping("/user/{id}")
  boolean deleteUser(long id) throws Exception;
}
