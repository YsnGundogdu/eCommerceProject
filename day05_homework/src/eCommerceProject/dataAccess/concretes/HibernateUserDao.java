package eCommerceProject.dataAccess.concretes;

import eCommerceProject.dataAccess.abstracts.UserDao;
import eCommerceProject.entities.concretes.User;

import java.util.List;

public class HibernateUserDao implements UserDao {
    @Override
    public void add(User user) {
        System.out.println(user.getEmail()+" : added.");
    }

    @Override
    public void delete(User user) {
        System.out.println(user.getEmail()+" : deleted.");
    }

    @Override
    public void update(User user) {
        System.out.println(user.getEmail()+" : updated.");
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
