public class UserService {
    public User disableUser(long id) {
        User user = UserDao.findUserById(id); // static call
        user.setEnabled(false);
        
        UserDao.save(user);                   // static call
        return user;
    }
}




public class UserDao{

    static User findUserById(long id);
    static void save (User);
}