public class UserService {
    public User disableUser(long id) {
        User user = findUserById(id);
        user.setEnabled(false);
        saveUser(user);
        return user;
    }
    User findUserById(long id) {
        return UserDao.findUserById(id); //static call 
    }
    void saveUser(User user) {
        UserDao.save(user);
    }
}



public class UserDao{

    static User findUserById(long id);
    static void save (User);
}



------------------


public class UserServiceTest {
    @Test
    public void disableUserTest() {
        UserService userService = new DummyUserService();
        User sampleUser = userService.disableUser(1);
        assertFalse(sampleUser.isEnabled());
    }
    class DummyUserService extends UserService {
        @Override
        User findUserById(long id) {
            User usr = new User();
            return usr;
        }
        @Override
        void saveUser(User user) {
            //  do nothing
        }
    }
}