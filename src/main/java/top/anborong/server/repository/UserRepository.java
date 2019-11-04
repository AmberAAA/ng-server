package top.anborong.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.anborong.server.dataobject.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByName(String name);

}
