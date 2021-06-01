package eCommerceProject;

import eCommerceProject.business.concretes.UserManager;
import eCommerceProject.core.GoogleRegisterAdapter;
import eCommerceProject.dataAccess.concretes.HibernateUserDao;
import eCommerceProject.entities.concretes.User;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager(new HibernateUserDao(), new GoogleRegisterAdapter());

        //SUCCESSFUL LOGIN
        User user1 = new User(1, "yasin ", "gündoğdu", "ysn_gundogdu@hotmail.com", "123456");
        userManager.register(user1);
        userManager.login(user1.getEmail(), user1.getPassword());
        System.out.println("***************************");

        //FAIL PASSWORD
        User user2 = new User(2, "ali", "demir", "ali.demir@gmail.com", "12");
        userManager.register(user2);
        userManager.login(user2.getEmail(), user2.getPassword());
        System.out.println("***************************");

        //FAIL FIRSTNAME AND LASTNAME
        User user3 = new User(3, "s", "b", "chandlerbing", "1234567");
        userManager.register(user3);
        userManager.login(user3.getEmail(), user3.getPassword());
        System.out.println("***************************");

        User user4 = new User(4,"joey","tribbiani","howyoudoingmail..com.","123456");
        userManager.register(user4);
        userManager.login(user4.getEmail(), user4.getPassword());
        System.out.println("***************************");
    }
}
