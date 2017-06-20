package tama.ac.jp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import tama.ac.jp.Service.UserService;
import tama.ac.jp.dao.UserDAO;

@SpringBootApplication
public class AccessDbApplication implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(AccessDbApplication.class, args);
	}

	@Autowired
	UserDAO userDao;

	@Autowired
	UserService userService;


	@Override
	public void run(String... args) throws Exception {
	}

}

