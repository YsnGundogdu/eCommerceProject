package eCommerceProject.business.concretes;

import eCommerceProject.business.abstracts.UserService;
import eCommerceProject.core.GoogleService;
import eCommerceProject.dataAccess.abstracts.UserDao;
import eCommerceProject.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements UserService {

    private List<String> emailList = new ArrayList<String>();
    private List<String> passwordList = new ArrayList<String>();

    private UserDao userDao;
    private GoogleService googleService;

    public UserManager(UserDao userDao, GoogleService googleService) {
        this.userDao = userDao;
        this.googleService = googleService;
    }

    public static boolean isEmailValid(String email){
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isMailValidOnClick(String email){
        return true;
    }



    @Override
    public void register(User user) {

        //PasswordCheck
        if (user.getPassword().length() < 6 || user.getPassword() == null){
            System.out.println("Your password must be at least 6 characters!");
            return;
        }

        //EmailCheck
        if (emailList.contains(user.getEmail())){
            System.out.println("This email address is already registered!");
            return;
        }

        //FirstAndLastNameCheck
        if (user.getFirstName().length() < 3 || user.getLastName().length() < 3){
            System.out.println("First and last name must be at least 2 characters!");
            return;
        }else{
            System.out.println("Your information is correct, please confirm your e-mail address and confirmation code. "+ user.getEmail()+" Please check.");
        }

        if (isMailValidOnClick(user.getEmail())){
            System.out.println("Successfully registered.");

            emailList.add(user.getEmail());
            passwordList.add(user.getPassword());
            this.userDao.add(user);
            this.googleService.registerToSystem(null);

        }else{
            System.out.println("Error! Please check your e-mail address.");
        }
    }

    @Override
    public void login(String email, String password) {
        if (emailList.contains(email) && passwordList.contains(password)){
            System.out.println("Login successful.");
        }else{
            System.out.println("Please check your e-mail address or password!");
        }
    }
}
