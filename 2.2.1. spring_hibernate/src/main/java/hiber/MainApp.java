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

      User employee1 = new User("Denis", "Terentyev", "Denis@mail.ru");
      User employee2 = new User("Daniil", "Pyrkh", "Daniil@mail.ru");
      User employee3 = new User("Aleksey", "Terentyev", "Aleksey@mail.ru");
      User employee4 = new User("Renat", "Araslanov", "Renat@mail.ru");

      employee1.setUserCar(new Car("Audi", 111));
      employee2.setUserCar(new Car("Mercedes", 222));
      employee3.setUserCar(new Car("Volkswagen", 333));
      employee4.setUserCar(new Car("Toyota", 444));

      userService.add(employee1);
      userService.add(employee2);
      userService.add(employee3);
      userService.add(employee4);
//
      System.out.println("----------------------------------------------------");
      System.out.println(userService.getUser("Audi", 111));
      System.out.println("----------------------------------------------------");
      System.out.println(userService.getUser("Toyota", 444));
      System.out.println("----------------------------------------------------");
      System.out.println(userService.getUser("Mercedes", 222));
      System.out.println("----------------------------------------------------");

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      context.close();
   }
}
