package com.tigapanah.user.controller;

import com.tigapanah.user.model.User;
import com.tigapanah.user.service.UserDataService;
import com.tigapanah.user.service.UserDataServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDataControllerImpl implements UserDataController {
  private UserDataService userDataService;

  public UserDataControllerImpl(UserDataServiceImpl userDataService) {
    this.userDataService = userDataService;
  }

  @Override
  public boolean isUserExists(long id) throws Exception{
    return userDataService.isUserExists(id);
  }

  @Override
  public User getUser(long id) throws Exception {
    return userDataService.getUser(id);
  }

  @Override
  public boolean addUser(User user) throws Exception{
    return userDataService.addUser(user);
  }

  @Override
  public boolean updateUser(User user) throws Exception{
    return userDataService.updateUser(user);
  }

  @Override
  public boolean deleteUser(long id) throws Exception{
    return userDataService.deleteUser(id);
  }
}
