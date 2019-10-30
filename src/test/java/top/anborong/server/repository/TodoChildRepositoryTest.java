package top.anborong.server.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.anborong.server.dataobject.TodoChild;
import top.anborong.server.dataobject.TodoMaster;

import javax.transaction.Transactional;

@SpringBootTest
class TodoChildRepositoryTest {

    @Autowired
    private TodoChildRepository repository;

    @Autowired TodoMasterRepository masterRepository;

//    @Test
//    @Transactional
//    public void saveOne () {
//
//        TodoMaster master = new TodoMaster("test");
//        master = masterRepository.saveAndFlush(master);
//
//        TodoChild child = new TodoChild("test child",0, master);
//        repository.save(child);
//    }
}