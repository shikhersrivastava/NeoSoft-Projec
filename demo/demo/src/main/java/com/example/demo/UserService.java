package com.example.demo1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@ComponentScan({"com.example.demo"})
public class UserService {

   @Qualifier
   private  UserRepo repos;



 // @Override
  public String post(UserDto userDto)
    {
        try {
            User user = new User();
            //  user.setAddress(userDto.getAddress());
             // user.setDOB(userDto.getDOB());
            user.setName(userDto.getName());
            //user.setPinCode(userDto.getPincode());
            //user.setSurName(userDto.getSurName());

            System.out.println("user={}" + user.getName());
           repos.save(user);
        }
        catch (NullPointerException ex)
        {
            ex.printStackTrace();
        }
        return "Success";

    }

    //@Override
    public String update(UserDto userDto)
    {

        Optional<User> user=repos.findById(userDto.getId());
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
        repos.save(user.get());
   return "Success";
    }

    //@Override
    public User findByName(String name)
    {
        User user=repos.findByName(name);
        if(user!=null)
        {
            return user;
        }
        return new User();

    }

  //  @Override
    public String deleteById(Long id)
    {
        Optional<User> user=repos.findById(id);
        if(!user.isEmpty())
        {
            repos.deleteById(id);
            return "User Deleted Succes fully";
        }
        return "User not found";

    }
}
