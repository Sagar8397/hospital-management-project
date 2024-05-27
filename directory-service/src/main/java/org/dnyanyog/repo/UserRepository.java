package org.dnyanyog.repo;

import org.dnyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepository extends JpaRepository<Users, Long> {

  //  @Query(
  //      "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.email_id =
  // :email_id")
  //  boolean existsByEmail_id(@Param("email_id") String email_id);

  //	@Query("SELECT u FROM User u WHERE u.email_id = :email_id")
  //	boolean existsByEmail_id(@Param("email_id") String email_id);

  //  List<Users> findByuser_id(long userId); // Declaration
  //
  //  @Query("SELECT u FROM Users u WHERE u.mobile = mobile")
  //  List<Users> findByMobile(String mobile);

  //  @Query("SELECT u FROM Users u WHERE u.email = :email and  u.username = :username")
  //  List<User> findByUsingEmailAndUserName(String email, String username);
  //
  //  @Query(value = "SELECT * FROM Users u WHERE u.email = ?1 or  u.username = ?2", nativeQuery =
  // true)
  //  List<User> findByUsingEmailOrUserName(String email, String username);
}
