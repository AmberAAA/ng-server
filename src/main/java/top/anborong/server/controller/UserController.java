package top.anborong.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import top.anborong.server.dataobject.User;
import top.anborong.server.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    public boolean login () {
        return  false;
    }


    @PostMapping("/user")
    public User signin (@RequestBody() User user) {
        logger.info(String.valueOf(user));
        return repository.save(user);
    }

    @GetMapping("/user")
    public User login (@Param("name") String name, @Param("password") String password) {
        return repository.findByName(name);
    }
}
