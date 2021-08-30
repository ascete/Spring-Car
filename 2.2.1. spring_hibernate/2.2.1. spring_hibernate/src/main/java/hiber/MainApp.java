package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car volvo = new Car("Volvo", 7);
        Car vaz = new Car("VAZ", 2105);
        Car toyota = new Car("Camry", 8);
        Car honda = new Car("Honda Accord", 8);

        User User1 = new User("User1", "Lastname1", "user1@mail.ru");
        User User2 = new User("User2", "Lastname2", "user2@mail.ru");
        User User3 = new User("User3", "Lastname3", "user3@mail.ru");
        User User4 = new User("User4", "Lastname4", "user4@mail.ru");

        userService.add(User1.setCar(volvo).setUser(User1));
        userService.add(User2.setCar(vaz).setUser(User2));
        userService.add(User3.setCar(toyota).setUser(User3));
        userService.add(User4.setCar(honda).setUser(User4));

        List<User> users = userService.listUsers();
        for (User user : users ){
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }
        System.out.println(userService.getUserCar("Volvo", 7));

        context.close();
    }
}
