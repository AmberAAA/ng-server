package top.anborong.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.anborong.server.dataobject.User;
import top.anborong.server.intf.LoginRequired;
import top.anborong.server.repository.UserRepository;
import top.anborong.server.utils.ResponseData;
import top.anborong.server.utils.ResponseDataUtils;
import top.anborong.server.utils.SystemEnums;
import top.anborong.server.utils.TokenUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public ResponseData signin (@RequestBody() User user,
                                HttpServletResponse response
    ) {
        logger.info(String.valueOf(user));
        try {
            repository.saveAndFlush(user);
            return ResponseDataUtils.buildSuccess(this.login(user.getName(), user.getPassword(), response));
        } catch (Exception e) {
            return  ResponseDataUtils.buildLogicError("用户已存在，请直接登录");
        }
    }

    @GetMapping
    public ResponseData login (@RequestParam(value = "name", required = true) String name,
                               @RequestParam(value = "password", required = true) String password,
                               HttpServletResponse response
    ) {
        User user = repository.findByName(name);
        if (user != null && user.getPassword().equals(password)) {
            String accToken = TokenUtils.createJwtToken(user.getId() + "");
//            response.setHeader("ACCESS-TOKEN", accToken);
            Cookie cookie = new Cookie(SystemEnums.ACCESS_TOKEN.getName(), accToken);
            response.addCookie(cookie);
            return ResponseDataUtils.buildSuccess(user);
        } else {
            return ResponseDataUtils.buildLogicError("账户或密码错误");
        }
    }

    @GetMapping("/test")
    @LoginRequired
    public ResponseData test (HttpServletRequest request) {
        return ResponseDataUtils.buildSuccess(request.getAttribute(SystemEnums.CURRENT_USER_ID.getName()));
    }

    @GetMapping("/test1")
    public ResponseData test1 () {
        return ResponseDataUtils.buildSuccess("测试1");
    }
}
