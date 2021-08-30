package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;


   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

//   @Override
//   public void delete(User user){
//      sessionFactory.createQuery("DELETE Player WHERE name = :name")
//              .setParameter("firstName", firstName).executeUpdate();
//   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery <User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public User  getUserCar(String model, int series) {
      return  (User) sessionFactory.getCurrentSession()
              .createQuery("select u from User u where u.car.model = :model and u.car.series = :series")
              .setParameter("model", model)
              .setParameter("series", series)
              .setMaxResults(1)
              .getSingleResult();
   }
}
