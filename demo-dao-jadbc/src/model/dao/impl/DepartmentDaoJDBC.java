package model.dao.impl;

import db.DB;
import db.DbExeption;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection con;

    public DepartmentDaoJDBC(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(Department obj) {

    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(
                    "select*from department where id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()){
                Department dep = new Department();
                dep.setId(rs.getInt("Id"));
                dep.setName(rs.getString("Name"));

                return dep;
            }
            return null;
        }catch (SQLException e){
            throw new DbExeption(e.getMessage());
        }finally {
            DB.fechaStatement(ps);
            DB.fechaResultset(rs);
        }


    }

    @Override
    public List<Department> findAll() {
        return List.of();
    }
}
