package top.anborong.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.anborong.server.dataobject.TodoMaster;

public interface TodoMasterRepository extends JpaRepository<TodoMaster, Integer> {
}
