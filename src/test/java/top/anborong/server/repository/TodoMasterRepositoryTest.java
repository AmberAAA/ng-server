package top.anborong.server.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.anborong.server.dataobject.TodoMaster;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class TodoMasterRepositoryTest {

    @Autowired
    private TodoMasterRepository repository;

//    @Test
//    @Transactional
//    public void saveOne () {
//        TodoMaster master = new TodoMaster("Amber");
//        repository.save(master);
//    }
//
//    public void getChild () {
//        TodoMaster master = repository.findById(14).get();
//        log.info(master.toString());
//    }
}