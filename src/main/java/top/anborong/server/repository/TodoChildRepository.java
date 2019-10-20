package top.anborong.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.anborong.server.dataobject.TodoChild;

public interface TodoChildRepository extends JpaRepository<TodoChild, Integer> {

}
