package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Department obj = new Department(1, "Tecnologia da informação");
        Seller seller = new Seller(21, "Samuel", "samuel@gmail.com", new Date(), 3000.00, obj);
        SellerDao sellerDao = DaoFactory.creatSellerDao();
        System.out.println(seller);
    }
}