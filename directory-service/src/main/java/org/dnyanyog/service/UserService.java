package org.dnyanyog.service;

import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

  public UserResponse addUser(UserRequest userRequest);

  public UserResponse getSingleUser(Long user_id);

  public UserResponse updateUser(Long user_id, UserRequest userRequest);

  public String deleteEmployee(Long user_id);
}
