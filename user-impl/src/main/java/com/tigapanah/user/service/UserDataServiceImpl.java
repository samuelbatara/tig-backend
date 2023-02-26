package com.tigapanah.user.service;

import com.tigapanah.user.model.User;
import com.tigapanah.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDataServiceImpl implements UserDataService {
  private UserRepository userRepository;
  private Logger logger = LoggerFactory.getLogger(UserDataServiceImpl.class);

  public UserDataServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public boolean isUserExists(long id) throws Exception {
    boolean result = false;
    try {
      result = userRepository.existsById(id);
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to check a user with id=%s", id), e
      );
    }

    return result;
  }

  @Override
  public User getUser(long id) throws Exception {
    Optional<User> user = null;
    try {
      user = userRepository.findById(id);
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to get user with id=%s", id), e);
    }

    if (user == null) {
      User auser = new User();
      auser.setFullName("sam");
      return auser;
    }

    if (user.isEmpty()) {
      return null;
    }

    return user.get();
  }

  @Override
  public boolean addUser(User user) throws Exception {
    try {
      userRepository.save(user);
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to save a user=%s", user), e);
    }

    return true;
  }

  @Override
  public boolean updateUser(User user) throws Exception {
    if (Long.valueOf(user.getId()) == null) {
      logger.error("Can't update user because id is not defined.");
      return false;
    }

    Optional<User> optionalUser = null;
    try {
      optionalUser = userRepository.findById(user.getId());
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to find a user=%s", user.toString()), e
      );
    }

    if (optionalUser.isEmpty()) {
      throw new Exception(
          String.format("User with id=%s is not registered", user.getId())
      );
    }

    User retreivedUser = optionalUser.get();
    if (user.getFullName() != null) {
      retreivedUser.setFullName(user.getFullName());
    }
    if (user.getAddress() != null) {
      retreivedUser.setAddress(user.getAddress());
    }
    if (user.getGender() != null) {
      retreivedUser.setGender(user.getGender());
    }
    if (user.getBirthDate() != null) {
      retreivedUser.setBirthDate(user.getBirthDate());
    }

    try {
      userRepository.save(retreivedUser);
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to save a user=%s", retreivedUser.toString()), e
      );
    }

    return true;
  }

  @Override
  public boolean deleteUser(long id) throws Exception {
    try {
      userRepository.deleteById(id);
    } catch (Exception e) {
      throw new Exception(
          String.format("Failed to delete a user with id=%s", id), e
      );
    }

    return true;
  }
}
