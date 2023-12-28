package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public List<User> index() {
      return entityManager
              .createQuery("SELECT u FROM User u ", User.class).getResultList();
   }

   @Transactional
   @Override
   public void save(User user) {
      entityManager.persist(user);
   }

   @Transactional
   @Override
   public void delete(int id) {
      entityManager.remove(entityManager.contains(getById(id)) ? getById(id) : entityManager.merge(getById(id)));
   }

   @Transactional
   @Override
   public void update(int id, User user) {
      User userToBeUpdate = getById(id);
      userToBeUpdate.setFirstName(user.getFirstName());
      userToBeUpdate.setLastName(user.getLastName());
      userToBeUpdate.setEmail(user.getEmail());
      entityManager.merge(userToBeUpdate);
   }

   @Override
   public User getById (int id) {
      return entityManager.find(User.class, id);
   }
}