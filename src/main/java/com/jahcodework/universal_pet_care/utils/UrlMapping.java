package com.jahcodework.universal_pet_care.utils;

public class UrlMapping {

    public static final String API = "/api/v1";

    // //localhost:9192/pet-care/api/v1/addNewUser
    public static final String ADDNEWUSER = API+"/addNewUser";

    // "/update/{userid}"
    // localhost:9192/pet-care/api/v1/update/idnumber
    public static final String UPDATE_USER = API+"/update/{userid}";

    // find user by id. "/user/{userid}"
    public static final String FIND_USER_BY_ID = API+"/finduserbyid/{userid}";
}
