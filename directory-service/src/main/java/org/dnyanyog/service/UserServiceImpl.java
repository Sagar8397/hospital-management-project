package org.dnyanyog.service;

import java.util.Optional;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserServiceImpl implements UserService {

  @Autowired UserRepository userRepo;

  @Autowired UserResponse userResponse;

  @Override
  public UserResponse addUser(UserRequest userRequest) {

    //    if (userRepo.existsByEmail_id(userRequest.getEmail_id())) {
    //      userResponse.setStatus("Error");
    //      userResponse.setMessage("Email is already exist! Please enter valid emailID");
    //      userResponse.setUserCode(0000);
    //    } else {
    Users userTable =
        Users.getInstance()
            .setFirst_name(userRequest.getFirst_name())
            .setMiddle_name(userRequest.getMiddle_name())
            .setLast_name(userRequest.getLast_name())
            .setAddress(userRequest.getAddress())
            .setDate_of_birth(userRequest.getDate_of_birth())
            .setEmail_id(userRequest.getEmail_id())
            .setMobile(userRequest.getMobile())
            .setHome_phone(userRequest.getHome_phone())
            .setUser_id(userRequest.getUser_id());

    try {
      userTable = userRepo.save(userTable);
    } catch (Exception e) {
      e.printStackTrace();
    }
    //    }

    userResponse.setStatus("Success");
    userResponse.setMessage("User Added Successfully");
    userResponse.setUserCode(Users.getInstance().getUser_code());

    return userResponse;
  }

  @Override
  public UserResponse getSingleUser(Long user_id) {

    Optional<Users> receivedData = userRepo.findById(user_id);

    if (receivedData.isEmpty()) {
      userResponse.setStatus("Fail");
      userResponse.setMessage("User not found");
    } else {
      Users user = receivedData.get();
      userResponse.setStatus("Success");
      userResponse.setMessage("User found");
      userResponse.getUserData().setFirst_name(user.getFirst_name());
      ;
      userResponse.getUserData().setMiddle_name(user.getMiddle_name());
      userResponse.getUserData().setLast_name(user.getLast_name());
      userResponse.getUserData().setDate_of_birth(user.getDate_of_birth());
      userResponse.getUserData().setAddress(user.getAddress());
      userResponse.getUserData().setMobile(user.getMobile());
      userResponse.getUserData().setHome_phone(user.getHome_phone());
      userResponse.getUserData().setEmail_id(user.getEmail_id());
      userResponse.getUserData().setUser_id(user.getUser_id());
    }
    return userResponse;
  }

  @Override
  public UserResponse updateUser(Long user_id, UserRequest userRequest) {

    Optional<Users> user = userRepo.findById(user_id);

    if (user == null) {
      userResponse.setStatus("unsuccess");
      userResponse.setMessage("User not found");
    } else {
      Users userTable =
          Users.getInstance()
              .setFirst_name(userRequest.getFirst_name())
              .setMiddle_name(userRequest.getMiddle_name())
              .setLast_name(userRequest.getLast_name())
              .setAddress(userRequest.getAddress())
              .setDate_of_birth(userRequest.getDate_of_birth())
              .setEmail_id(userRequest.getEmail_id())
              .setMobile(userRequest.getMobile())
              .setHome_phone(userRequest.getHome_phone())
              .setUser_id(userRequest.getUser_id());

      try {
        userTable = userRepo.save(userTable);
      } catch (Exception e) {
        e.printStackTrace();
      }

      userTable = userRepo.save(userTable);
      userResponse.setStatus("Success");
      userResponse.setMessage("User updated successfuly");
    }

    return userResponse;
  }

  @Override
  public String deleteEmployee(Long user_id) {
    userRepo.deleteById(user_id);

    return "user of id " + user_id + " is deleted";
  }
}
