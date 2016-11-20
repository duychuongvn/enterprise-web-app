import com.github.duychuongvn.user.dao.entity.Account;
import com.github.duychuongvn.user.exception.AccountAlreadyExistException;
import com.github.duychuongvn.user.exception.UserAlreadyExistsException;
import com.github.duychuongvn.user.exception.UserNotFoundException;
import com.github.duychuongvn.user.manager.AccountManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by huynhduychuong on 10/8/2016.
 */
public class App {
    public static void main(String[] args) throws UserAlreadyExistsException, UserNotFoundException, AccountAlreadyExistException {
        ApplicationContext context = new ClassPathXmlApplicationContext("user-applicationContext.xml");
        AccountManager accountManager = context.getBean(AccountManager.class);
        Account account = new Account();
        account.setEmail("1111@gmail.com");
        account.setPassword("wwewew");
        account.setUsername("Acc1");

        accountManager.create(account);
//        UserProfile user2 = userManager.createUser(user);
//        UserProfile user3 = userManager.findUserById(user2.getId());
//        System.out.println(user3);
    }
}
