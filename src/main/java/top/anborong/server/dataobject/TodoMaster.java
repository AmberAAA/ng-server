package top.anborong.server.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@DynamicUpdate
public class TodoMaster implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String title;

    private int state;

    private Date createTime;

    private Date updateTime;

    @OneToMany(fetch=FetchType.EAGER,cascade={CascadeType.REMOVE}, mappedBy="master_id")
    private List<TodoChild> children;

    public TodoMaster(String title) {
        this.title = title;
        this.state = 0;
    }

    public TodoMaster() {
    }
}
