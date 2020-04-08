package com.thangdtran.user_services.controllers;

import com.thangdtran.user_services.domain.model.User;
import com.thangdtran.user_services.interfaces.ProductFeignClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryController {

    @Autowired
    ProductFeignClient productFeignClient;

    @RequestMapping(path = "/user/{user_id}/history/{history_id}", produces = "application/json")
    public ResponseEntity<Object> histories(@PathVariable("user_id") String userId,
                                            @PathVariable("history_id") String historyId) {
        // user
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

        // history
        JSONObject[] historiesObject = new JSONObject[1];
        JSONObject historyObject = new JSONObject();
        historyObject.put("history_id", historyId);

        // get product info by feign
        historyObject.put("product", new JSONObject(productFeignClient.getProductInfo("1")));
        historiesObject[0] = historyObject;

        // response
        JSONObject responseObject = new JSONObject();
        responseObject.put("user", userObject);
        responseObject.put("history", historiesObject);

        return new ResponseEntity<Object>(responseObject.toString(), HttpStatus.OK);
    }
}
