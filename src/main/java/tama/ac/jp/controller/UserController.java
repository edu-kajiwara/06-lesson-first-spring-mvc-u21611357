package tama.ac.jp.controller;

import lombok.val;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tama.ac.jp.dao.UserDAO;
import tama.ac.jp.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/05/23.
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
        @Autowired
        UserDAO userDAO;
        @RequestMapping(method = RequestMethod.GET)
        public List<User> showUserList(){
            val result = userDAO.selectUserList();
            return result;
        }
        @RequestMapping(value="{userId}",method = RequestMethod.GET)
        public User showUser(@PathVariable String userId)
        {
            val user = userDAO.selectUser(userId);
            return user;
        }
        @RequestMapping(method = RequestMethod.PUT)
        public void createUser(@RequestBody User user){
            userDAO.insertUser(user);
        }
        @RequestMapping(value="{userId}",method = RequestMethod.POST)
        public void updateUser(@RequestBody User user)
        {
            userDAO.updateUser(user);
        }
        @RequestMapping(value = "{userId}",method = RequestMethod.DELETE)
        public void deleteUser(@PathVariable String userId)
        {
            userDAO.deleteUser(userId);
        }
}
