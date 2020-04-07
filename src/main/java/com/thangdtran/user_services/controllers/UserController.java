package com.thangdtran.user_services.controllers;

import com.thangdtran.user_services.domain.model.User;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping(path = "/user/{id}", produces = "application/json")
    public ResponseEntity<Object> getUserInfo(@PathVariable("id") String userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName("USER_NAME_" + userId);
        user.setAddress( "No." + userId + " Binh Tan district, Ho Chi Minh city");
        user.setGender(Integer.parseInt(userId) % 2 == 1 ? "Male" : "Female");
        user.setPhoneNumber("0909123456");

        JSONObject userObject = new JSONObject();
        userObject.put("user_id", user.getUserId());
        userObject.put("user_name", user.getUserName());
        userObject.put("user_address", user.getAddress());
        userObject.put("gender", user.getGender());
        userObject.put("phone", user.getPhoneNumber());

        return new ResponseEntity<Object>(userObject.toString(), HttpStatus.OK);
    }

    @PostMapping(path = "/user/{id}/{name}", produces = "application/json")
    public ResponseEntity<Object> updateUsername(@PathVariable("id") String userId,
                                                 @PathVariable("name") String updatedName) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName("USER_NAME_" + userId);
        user.setAddress( "No." + userId + " Binh Tan district, Ho Chi Minh city");

        String status = "OK";
        String message = updatedName;
        if (updatedName.equals(user.getUserName())) {
            status = "FAIL";
            message = "DUPLICATED NAME";
        }

        JSONObject responseObject = new JSONObject();
        responseObject.put("status", status);
        responseObject.put("message", message);

        return new ResponseEntity<Object>(responseObject.toString(), HttpStatus.OK);
    }
}
