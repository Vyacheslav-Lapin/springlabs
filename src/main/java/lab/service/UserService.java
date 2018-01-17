package lab.service;

import lab.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.transaction.annotation.Isolation.READ_COMMITTED;
import static org.springframework.transaction.annotation.Isolation.SERIALIZABLE;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;
import static org.springframework.transaction.annotation.Propagation.SUPPORTS;

public interface UserService {
    @Transactional(readOnly = true, propagation = SUPPORTS, isolation = READ_COMMITTED)
    List<User> loadAllUsers();

    @Transactional(propagation = REQUIRES_NEW, isolation = SERIALIZABLE)
    void saveUser(User user);
}
