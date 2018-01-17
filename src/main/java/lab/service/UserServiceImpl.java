package lab.service;

import lab.dao.UserDao;
import lab.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.transaction.annotation.Isolation.READ_COMMITTED;
import static org.springframework.transaction.annotation.Isolation.SERIALIZABLE;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;
import static org.springframework.transaction.annotation.Propagation.SUPPORTS;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    @Transactional(readOnly = true, propagation = SUPPORTS, isolation = READ_COMMITTED)
    public List<User> loadAllUsers() {
        return userDao.selectAll();
    }

    @Override
    @Transactional(propagation = REQUIRES_NEW, isolation = SERIALIZABLE)
    public void saveUser(User user) {
        userDao.insert(user);
    }
}
