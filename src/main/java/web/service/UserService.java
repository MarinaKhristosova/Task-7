package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> index();
    void save(User user);
    void delete(int userId);
    void update(int userId, User user);
    User getById(int userId);
}
