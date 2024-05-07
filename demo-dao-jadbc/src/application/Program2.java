package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.creatDepartmentDao();

        System.out.println("TESTE 01");
        Department department = departmentDao.findById(1);
        System.out.println(department);
    }
}