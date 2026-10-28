package org.softwaretechnologies.employee;

/**
 * Тип сотрудника
 */
public enum EmployeeType {
    /*
    Формула вычисления зп: если месяц четный, то baseSalary, иначе baseSalary/2
     */
    Manager{
        @Override
        public Employee createEmployee(String name, int salary) {
            return new Manager(name, salary);
        }
    },

    /*
    Формула вычисления зп: всегда baseSalary
     */
    Programmer{
        @Override
        public Employee createEmployee(String name, int salary) {
            return new Programmer(name, salary);
        }
    },
    /*
    Формула вычисления зп: baseSalary * количество дней в месяце в текущем году
    Вычисление количества дней в месяце: YearMonth.of(LocalDate.now().getYear(), month).lengthOfMonth()
     */
    Tester{
        @Override
        public Employee createEmployee(String name, int salary) {
            return new Tester(name, salary);
        }
    };

    public abstract Employee createEmployee(String name, int salary);

}
