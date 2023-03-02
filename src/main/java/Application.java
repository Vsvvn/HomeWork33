import model.City;
import model.Employee;
import service.EmployeeDAO;
import service.EmployeeDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String password = "rf8zZ1qsL!!!";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            // Создаем объект класса BookDAOImpl
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);

            City city = new City(6, "Ялта");
            Employee employee1 = new Employee(
                    10,
                    "Галина",
                    "Петрова",
                    "жен",
                    38,
                    6,
                    city);


//            1. Метод добавления объекта +
            employeeDAO.create(employee1);


//            2. Метод получения конкретного объекта Employee по id +
            System.out.println(employeeDAO.readById(10));

//            3. Метод получения списка всех объектов Employee из базы (для демонстрации, рабочий находится ниже) +
            employeeDAO.readAll();

//            4. Метод изменения конкретного объекта Employee в базе по id +
            employeeDAO.updateAgeById(4, 35);


//            5. Метод удаления конкретного объекта Employee из базы по id +
            employeeDAO.deleteById(10);


//             Создаем список наполняя его объектами, которые получаем
//             путем вызова метода для получения всех элементов таблицы +
            List<Employee> list = new ArrayList<>(employeeDAO.readAll());

//             Выведем список в консоль
            for (Employee employee : list) {
                System.out.println(employee);
            }
        }
    }
}
