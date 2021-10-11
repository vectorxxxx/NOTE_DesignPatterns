package com.vectorx.principle.demeter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//分析SchoolManager类
// Employee、CollegeManager 直接朋友
// CollegeEmployee不是直接朋友，而是一个陌生类，这样违背了迪米特法则
public class Demeter2 {
    @Test
    public void test() {
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManager());
    }

    //总部员工
    class Employee {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    //学院员工
    class CollegeEmployee {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    //学院员工管理类
    class CollegeManager {
        public List<CollegeEmployee> getAllEmployee() {
            List<CollegeEmployee> list = new ArrayList<>();
            CollegeEmployee collegeEmployee;
            for (int i = 0; i < 10; i++) {
                collegeEmployee = new CollegeEmployee();
                collegeEmployee.setId("学院员工id=" + i);
                list.add(collegeEmployee);
            }
            return list;
        }

        public void printAllEmployee() {
            System.out.println("--------------学院员工--------------");
            List<CollegeEmployee> list1 = getAllEmployee();
            for (CollegeEmployee collegeEmployee : list1) {
                System.out.println(collegeEmployee.getId());
            }
        }
    }

    //总部员工管理类
    class SchoolManager {
        public List<Employee> getAllEmployee() {
            List<Employee> list = new ArrayList<>();
            Employee employee;
            for (int i = 0; i < 5; i++) {
                employee = new Employee();
                employee.setId("总部员工id=" + i);
                list.add(employee);
            }
            return list;
        }

        public void printAllEmployee(CollegeManager sub) {
            sub.printAllEmployee();
            System.out.println("---------------总部员工-------------");
            List<Employee> list2 = getAllEmployee();
            for (Employee employee : list2) {
                System.out.println(employee.getId());
            }
        }
    }
}
