package com.example.Map_rest.Controller;

import com.example.Map_rest.Category.Map;
import com.example.Map_rest.Category.User;
import com.example.Map_rest.Service.service_class;
import com.example.Map_rest.Service.service_class_user;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/User")
public class user_controller {
    @Autowired
    service_class_user scobj;

    @GetMapping("")
    public List<User> list() {
        return scobj.listAlldata_user();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try {
            User user = scobj.get_user(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody User user) {
        scobj.savedata_user(user);
    }

    @PostMapping("/login")
    public HashMap<String,String> login1(@RequestBody User user)
    {
        HashMap<String,String> hashMap=new HashMap<>() ;
        try {
            User user1 = scobj.get_user_by_email_and_password(user.getName(), user.getPassword());
            String name=user1.getName();
            hashMap.put("msg","Login_Success");
            return hashMap;
        }
        catch (NoSuchElementException | NullPointerException a) {
            hashMap.put("User","not found");
            return hashMap;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
        try {
            User user1= scobj.get_user(id);
            user1.setId(id);
            scobj.savedata_user(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        scobj.delete_user(id);
    }
}
