package com.tigapanah.user.service;

import com.tigapanah.user.model.User;

public interface UserDataService {
  boolean isUserExists(long id) throws Exception;
  User getUser(long id) throws Exception;
  boolean addUser(User user) throws Exception;
  boolean updateUser(User user) throws Exception;
  boolean deleteUser(long id) throws Exception;
}
