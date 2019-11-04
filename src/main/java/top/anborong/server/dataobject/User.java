package top.anborong.server.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import top.anborong.server.controller.Todo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String password;

    private Date createTime;

    private Date updateTime;

    public User () {}

    public User (String name, String password) {
        this.name = name;
        this.password = password;
    }
}
