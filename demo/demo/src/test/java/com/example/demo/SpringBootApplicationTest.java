package com.example.demo;

import com.example.demo.User;
import com.example.demo.UserRepo;
import com.example.demo.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootApplicationTest {


    @Autowired
    private UserService userService;

    @MockBean
    private UserRepo userRepo;

    private User createUser()
    {
        User user=new User();
        user.setSurName("Kumar");
        user.setName("Shikher");
        user.setAddress("Delhi");
        user.setPinCode("201204");
        user.setId(123123L);
        return user;
    }
    @Test
    public void delete() throws Exception {
        User expected = createUser();
        userService.deleteById(expected.getId());
        Mockito.verify(userRepo).delete(expected);
    }

    @Test
    public void findByName() throws Exception {
        User expected = createUser();
        String result="Delete Succesfully";
        userService.findByName(expected.getName());
    }
}
