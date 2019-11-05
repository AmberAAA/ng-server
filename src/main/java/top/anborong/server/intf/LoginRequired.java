package top.anborong.server.intf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.common.util
 * @Author:
 * @CreateTime: 2019-03-04 15:38
 * @Description: 在需要登录验证的Controller的方法上使用此注解
 */
@Target({ElementType.METHOD})
@Retention( RetentionPolicy.RUNTIME )
public @interface LoginRequired {
}
