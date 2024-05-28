package org.dnyanyog.service;

import java.util.List;
import java.util.Optional;

import org.dnyanyog.common.ResponseCode;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class UserManagementSeriveImp {

  @Autowired private UserRepository userRepo;
  @Autowired private UserResponse userResponse;

  public UserResponse addUser(@Valid UserRequest request) throws Exception {

    UserResponse userResponse = UserResponse.getInstance();

    Users newUser = new Users();
    newUser.setConfirm_password(request.getConfirm_password());
    newUser.setEmail(request.getEmail());
    newUser.setMobile_number(request.getMobile_number());
    newUser.setPassword(request.getPassword());
    newUser.setRole(request.getRole());
    newUser.setUser_name(request.getUser_name());

    try {
      newUser = userRepo.save(newUser);
      populateUserResponse(userResponse, newUser);
      userResponse.setStatus(ResponseCode.USER_ADDED.getStatus());
      userResponse.setMessage(ResponseCode.USER_ADDED.getMessage());
    } catch (Exception e) {
      userResponse.setStatus(ResponseCode.USER_FAILED.getStatus());
      userResponse.setMessage(ResponseCode.USER_FAILED.getMessage());
    }

    return userResponse;
  }

  public UserResponse updateUser(long patient_id, UserRequest request) {

    Optional<Users> optionalUser = userRepo.findById(patient_id);

    if (optionalUser.isEmpty()) {
      userResponse.setMessage(ResponseCode.USER_NOT_UPDATED.getMessage());
      userResponse.setStatus(ResponseCode.USER_NOT_UPDATED.getStatus());
    } else {
      Users user = optionalUser.get();

      userResponse.setConfirm_password(request.getConfirm_password());
      userResponse.setEmail(request.getEmail());
      userResponse.setMobile_number(request.getMobile_number());
      userResponse.setPassword(request.getPassword());
      userResponse.setRole(request.getRole());
      userResponse.setUser_name(request.getUser_name());

      userRepo.save(user);

      userResponse.setMessage(ResponseCode.USER_UPDATED.getMessage());
      userResponse.setStatus(ResponseCode.USER_UPDATED.getStatus());
    }
    return userResponse;
  }

  public UserResponse getSingleUser(long patient_id) {
    Optional<Users> optionalUser = userRepo.findById(patient_id);

    UserResponse userResponse = UserResponse.getInstance();
    if (optionalUser.isEmpty()) {
      userResponse.setMessage(ResponseCode.SEARCH_USER_FAILED.getMessage());
      userResponse.setStatus(ResponseCode.SEARCH_USER_FAILED.getStatus());
    } else {
      Users user = optionalUser.get();
      populateUserResponse(userResponse, user);
      userResponse.setMessage(ResponseCode.SEARCH_USER.getMessage());
      userResponse.setStatus(ResponseCode.SEARCH_USER.getStatus());
    }
    return userResponse;
  }

  public UserResponse deleteUser(long patient_id) {

    Optional<Users> optionalUser = userRepo.findById(patient_id);

    if (optionalUser.isEmpty()) {
      userResponse.setMessage(ResponseCode.NOT_DELETE_USER.getMessage());
      userResponse.setStatus(ResponseCode.NOT_DELETE_USER.getStatus());
    } else {

      Users user = optionalUser.get();
      userRepo.delete(user);

      userResponse.setMessage(ResponseCode.DELETE_USER.getMessage());
      userResponse.setStatus(ResponseCode.DELETE_USER.getStatus());
      userResponse.setConfirm_password(user.getConfirm_password());
      userResponse.setEmail(user.getEmail());
      userResponse.setMobile_number(user.getMobile_number());
      userResponse.setPassword(user.getPassword());
      userResponse.setRole(user.getRole());
      userResponse.setUser_name(user.getUser_name());
    }
    return userResponse;
  }

  private void populateUserResponse(UserResponse response, Users users) {
    response.setConfirm_password(users.getConfirm_password());
    response.setEmail(users.getEmail());
    response.setMobile_number(users.getMobile_number());
    response.setPassword(users.getPassword());
    response.setRole(users.getRole());
    response.setUser_name(users.getUser_name());
  }
}
