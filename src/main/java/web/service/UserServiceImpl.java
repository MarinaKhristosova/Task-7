package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(int userId) {
        userDao.delete(userId);
    }

    @Override
    public void update(int userId, User user) {
        userDao.update(userId, user);
    }

    @Override
    public User getById(int userId) {
        return userDao.getById(userId);
    }
}
