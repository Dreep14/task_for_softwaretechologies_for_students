package org.softwaretechnologies;

import org.softwaretechnologies.employee.Employee;
import org.softwaretechnologies.employee.EmployeeType;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private final String name;
    private final List<Employee> employeeList;

    public Company(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    /**
     * Создает и добавляет сотрудника в коллекцию employeeList.
     * @param name имя работника
     * @param baseSalary базовая зарплата сотрудника
     * @param type тип работника
     */
    public void addEmployee(String name, int baseSalary, EmployeeType type) {
        // TODO: реализуйте вышеуказанную функцию
        Employee employee =
                EmployeeFactory.createEmployee(name, baseSalary, type);

        employeeList.add(employee);
    }

    /**
     * Возвращает сумму зарплат всех сотрудников за указанный месяц
     * @param month номер месяца
     * @return сумма зарплат всех сотрудников за указанный месяц
     */
    public int getMonthSalary(int month) {
        // TODO: реализуйте вышеуказанную функцию
        int sum = 0;

        for (Employee employee : employeeList) {
            sum += employee.getMonthSalary(month);
        }

        return sum;
    }

    public String getName() {
        return name;
    }
}
