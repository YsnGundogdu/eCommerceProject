package eCommerceProject.dataAccess.abstracts;

import eCommerceProject.entities.concretes.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(User user);
    void update(User user);
    List<User> getAll();
}
