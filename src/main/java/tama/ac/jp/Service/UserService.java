package tama.ac.jp.Service;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tama.ac.jp.dao.UserDAO;
import tama.ac.jp.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/05/30.
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void multiUserRegister(List<User> users){
        for (User user:users) {
            userDAO.insertUser(user);
        }
    }
}
