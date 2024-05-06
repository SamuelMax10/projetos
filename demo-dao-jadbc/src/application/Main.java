package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.creatSellerDao();

//        System.out.println("=== TESTE 01: Seller findById ===");
//        Seller seller = sellerDao.findById(1);
//        System.out.println(seller);
//
//        System.out.println("\n=== TESTE 02: Seller findByIdDepartment ===");
//        Department dep = new Department(2, null);
//        List<Seller> list = sellerDao.findByDepartment(dep);
//        for (Seller obj : list) {
//            System.out.println(obj);
//        }
//
//        System.out.println("\n=== TESTE 03: Seller findAll ===");
//        list = sellerDao.findAll();
//        for (Seller obj : list) {
//            System.out.println(obj);
//        }
//
//        System.out.println("\n=== TESTE 04: Seller insert ===");
//        Seller seller1 = new Seller(null, "Greg", "greg@idg-eng.com", new Date(), 4000.00, dep);
//        sellerDao.Insert(seller1);
//        System.out.println("Inserido novo id: " + seller1.getId());
//
//        System.out.println("\n=== TESTE 05: Seller update ===");
//        seller = sellerDao.findById(1);
//        seller.setName("Maria Alice");
//        sellerDao.update(seller);
//        System.out.println("Atualização completa!");

        System.out.println("\n=== TESTE 06: Seller delete ===");
        System.out.print("Entre com um id para deletar: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Foi excluido o id: " + id);

        sc.close();
    }
}