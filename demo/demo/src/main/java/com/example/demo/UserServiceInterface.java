package com.example.demo;

import com.example.demo.UserDto;
import org.springframework.stereotype.Component;

@Component
public interface UserServiceInterface {


    public String post(UserDto userDto);

    public String update(UserDto userDto);

    public User findByName(String name);
}
