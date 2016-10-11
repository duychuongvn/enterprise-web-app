import com.github.duychuongvn.user.dao.entity.User;
import com.github.duychuongvn.user.dao.repository.UserRepository;
import com.github.duychuongvn.user.exception.UserAlreadyExistsException;
import com.github.duychuongvn.user.exception.UserNotFoundException;
import com.github.duychuongvn.user.manager.UserManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by huynhduychuong on 10/8/2016.
 */
public class App {
    public static void main(String[] args) throws UserAlreadyExistsException, UserNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("user-applicationContext.xml");
        UserManager userManager = context.getBean(UserManager.class);
        User user = new User();
        user.setEmail("1111@gmail.com");
        user.setPhoneNumber("a111111");
        user.setUsername("ss111111s");
        user.setPassword("101");
        User user2 = userManager.createUser(user);
        User user3 = userManager.findUserById(user2.getId());
        System.out.println(user3);
    }
}
