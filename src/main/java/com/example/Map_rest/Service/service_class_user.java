package com.example.Map_rest.Service;

import com.example.Map_rest.Category.Map;
import com.example.Map_rest.Category.User;
import com.example.Map_rest.Repo.user_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class service_class_user {

    @Autowired
    private user_repo ur_obj;


     public List<User> listAlldata_user() {
        return ur_obj.findAll();
    }

    public void savedata_user(User ur) {
        ur_obj.save(ur);
    }

    public User get_user(Integer id) {
        return ur_obj.findById(id).get();
    }

    public void delete_user(Integer id) {
        ur_obj.deleteById(id);
    }

    public User get_user_by_email_and_password(String name, String password){
         return ur_obj.findwithEmail_and_password(name,password);
    }

}
