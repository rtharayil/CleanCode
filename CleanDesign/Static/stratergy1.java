public class UserService {
    @Inject
    UserDaoWrapper userDao;
    
    public User disableUser(long id) {
        User user = userDao.findUserById(id);
        user.setEnabled(false);
        userDao.save(user);
        return user;
    }
}

public class UserDaoWrapper{

     User findUserById(long id);
     {
          return UserDao.findUserById(id); // static call
     }
     void save (User);
     {
         
      UserDao.save(user); 
     }
}


public class UserDao{

    static User findUserById(long id);
    static void save (User);
}














-------------------------------------------------

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock    //  Mocking the UserDao so it'll not make database calls
    UserDaoWrapper userDaoMock;
    @InjectMocks    // Asking Mockito to inject all mocked instances into this class 
    UserService userService = new UserService();
    @Test
    public void disableUserTest() {
        User sampleUser = new User();
        sampleUser.setEnabled(true);
        //  Tell the finder method of the DAO class what to do if it's called
        when(userDaoMock.findUserById(1)).thenReturn(sampleUser);   
        sampleUser = userService.disableUser(1);
        assertFalse(sampleUser.isEnabled());
    }
}
