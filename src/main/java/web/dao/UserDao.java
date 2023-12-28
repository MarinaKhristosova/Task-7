package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;
import java.util.List;
@Component
public interface UserDao {
   List<User> index();
   public User getById (int id);
   public void save (User user);
   public void update (int id, User user);
   public void delete (int id);
}