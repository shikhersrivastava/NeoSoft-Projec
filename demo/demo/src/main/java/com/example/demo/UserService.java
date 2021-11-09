package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
//@ComponentScan({"com.example.demo"})
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepo repo;



  @Override
  public String post(UserDto userDto)
    {
        try {
            User user = new User();
              user.setAddress(userDto.getAddress());
              user.setDOB(userDto.getDOB());
            user.setName(userDto.getName());
            user.setPinCode(userDto.getPincode());
            user.setSurName(userDto.getSurName());

            System.out.println("user={}" + user.getName());
            repo.save(user);
        }
        catch (NullPointerException ex)
        {
            ex.printStackTrace();
        }
        return "Success";

    }

    @Override
    public String update(UserDto userDto)
    {

        Optional<User> user=repo.findById(userDto.getId());
        if(user.isEmpty())
        {
            System.out.println("data not found");
            return "Data not found";
        }
        user.get().setSurName(userDto.getSurName());
        user.get().setPinCode(userDto.getPincode());
        user.get().setAddress(userDto.getAddress());
        user.get().setDOB(userDto.getDOB());
        user.get().setName(userDto.getName());
        repo.save(user.get());
   return "Success";
    }

    @Override
    public User findByName(String name)
    {
        User user=repo.findByName(name);
        if(user!=null)
        {
            return user;
        }
        return new User();

    }
}
