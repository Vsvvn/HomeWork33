package service;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {

    // 1. Метод добавления объекта
    void create(Employee employee);

    //2. Метод получения конкретного объекта Employee по id
    Employee readById(int id);

    //3. Метод получения списка всех объектов Employee из базы
    List<Employee> readAll();

    //4. Метод изменения конкретного объекта Employee в базе по id
    void updateAgeById(int id, int age);

    //5. Метод удаления конкретного объекта Employee из базы по id
    void deleteById(int id);
}
