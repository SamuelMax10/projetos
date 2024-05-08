package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class Program2 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.creatDepartmentDao();

        System.out.println("\nTESTE 01 - findById");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("\nTESTE 02 - findAll");
        List<Department> list = departmentDao.findAll();
        for (Department dep : list){
            System.out.println(dep);
        }

        System.out.println("\nTESTE 03 - insert");
        department = new Department(null,"Engineering");
        departmentDao.insert(department);
        System.out.println("Inserido novo id: "+department.getId());

        System.out.println("\nTESTE 04 - update");
        department = departmentDao.findById(3);
        department.setName("Science");
        departmentDao.update(department);
        System.out.println("Atualização completa");
    }
}