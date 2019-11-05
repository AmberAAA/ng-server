package top.anborong.server.Interceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.anborong.server.dataobject.User;
import top.anborong.server.intf.LoginRequired;
import top.anborong.server.repository.UserRepository;
import top.anborong.server.utils.ResponseDataUtils;
import top.anborong.server.utils.ResponseEnums;
import top.anborong.server.utils.SystemEnums;
import top.anborong.server.utils.TokenUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserRepository repository;

    private Logger logger  = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if ( !(handler instanceof HandlerMethod) ) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 判断接口是否需要登录
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);


        if (methodAnnotation != null) {
            // 有注解，则需要登录
            String accessToken = null;
            // String accessToken = request.getHeader("ACCESS-TOKEN");
            Cookie[] cookies = request.getCookies();

            if (cookies == null) {
                // throw new Exception("需要登录");
                returnJson(response, ResponseDataUtils.buildError(ResponseEnums.LOGINERROR).toString());
                return false;
            }

            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(SystemEnums.ACCESS_TOKEN.getName())) {
                    accessToken = cookie.getValue();
                }
            }

            Claims claims;
            try {
                claims = TokenUtils.parseJWT(accessToken);
                request.setAttribute(SystemEnums.CURRENT_USER_ID.getName(), claims.getId());
            }  catch (Exception e ) {
                returnJson(response, ResponseDataUtils.buildError(ResponseEnums.LOGINERROR).toString());
                return false;
            }
        }
        return true;
    }

    private void returnJson(HttpServletResponse response, String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
        } catch (IOException e) {
            logger.error("response error",e);
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
