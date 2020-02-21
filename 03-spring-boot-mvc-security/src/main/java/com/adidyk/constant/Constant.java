package com.adidyk.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constant {

    @Value("${message.enteredLoginIsDuplicated}")
    public String enteredLoginIsDuplicated;

    @Value("${message.newUserAdded}")
    public String newUserAdded;

    @Value("${message.newUserNotAdded}")
    public  String newUserNotAdded;

    @Value("${message.userUpdate}")
    public String userUpdate;

    @Value("${message.userNotUpdate}")
    public  String userNotUpdate;

    @Value("${message.userDelete}")
    public  String userDelete;

    @Value("${message.getAllUser}")
    public  String getAllUser;

    @Value("${const.url}")
    public String url;

    @Value("${const.message}")
    public String message;

    @Value("${const.index}")
    public String index;

    @Value("${const.save}")
    public String save;

    @Value("${const.update}")
    public String update;

}