package top.anborong.server.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class TodoChild implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String title;

    private int state;

    private Date createTime;

    private Date updateTime;

    private int master_id;

    public TodoChild() {
    }

    public TodoChild(String title, int state, TodoMaster master) {
        this.title = title;
        this.state = state;
//        this.master = master;
    }
}
