package com.bikkadit.electronicsstore.services;

import com.bikkadit.electronicsstore.dtos.PageableResponse;
import com.bikkadit.electronicsstore.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    //create
    UserDto createUser (UserDto userDto);

   //Update
    UserDto updateUser(UserDto userDto,String userId );


    // delete
    void deleteUser (String userId);

    //GetAll user
    PageableResponse<UserDto> getAllUser(int pageNumber, int pageSize, String sortBy, String sortDir);


    //get single by user

    UserDto getUserById (String userId);

    // get single by user email

    UserDto getUserByEmail (String email);


    // search user
    List<UserDto> searchUser (String keyword);



    // other user specific features  provide






}
