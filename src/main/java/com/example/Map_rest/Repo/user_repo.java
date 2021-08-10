package com.example.Map_rest.Repo;
import com.example.Map_rest.Category.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface user_repo extends JpaRepository<User,Integer> {

    @Query("select u from User u where u.name = ?1 and u.password =?2")
     User findwithEmail_and_password(String name, String password);

}
