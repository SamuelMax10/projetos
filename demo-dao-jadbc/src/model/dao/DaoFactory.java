package model.dao;

import db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
    public static SellerDao creatSellerDao() {
        return new SellerDaoJDBC(DB.getConexao());
    }
    public static DepartmentDao creatDepartmentDao(){
        return new DepartmentDaoJDBC(DB.getConexao());
    }
}
