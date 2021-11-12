package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
public class Controller {


    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String post(@RequestBody UserDto userDto)
    {
       String result= userService.post(userDto);
       return result;
    }
    @PutMapping("/update")
    public String update(@RequestBody UserDto userDto)
    {
        if(userDto.getId()==null)
        {
            System.out.println("Id can not be empty");
            return "Id can not be empty";
        }
        String result=userService.update(userDto);
        return result;
    }
    @GetMapping("/searchByName/{name}")
    public User searchByName(@PathVariable String name)
    {
        User user=userService.findByName(name);
        if(user!=null)
        {
            return user;
        }
        return user;
    }
    @DeleteMapping("/deleteByid/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        String user=userService.deleteById(id);
        return user;
    }

}
