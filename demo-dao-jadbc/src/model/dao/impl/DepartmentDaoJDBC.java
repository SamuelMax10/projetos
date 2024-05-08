package model.dao.impl;

import db.DB;
import db.DbExeption;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection con;

    public DepartmentDaoJDBC(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(
                    "insert into department " +
                            "(Name) values (?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, obj.getName());
            int linhasafetadas = ps.executeUpdate();
            if (linhasafetadas > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
            } else {
                throw new DbExeption("Erro inesperado, nehuma linha afetada");
            }
        } catch (SQLException e) {
            throw new DbExeption(e.getMessage());
        } finally {
            DB.fechaStatement(ps);
        }
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
            if (rs.next()) {
                Department dep = new Department();
                dep.setId(rs.getInt("Id"));
                dep.setName(rs.getString("Name"));

                return dep;
            }
            return null;
        } catch (SQLException e) {
            throw new DbExeption(e.getMessage());
        } finally {
            DB.fechaStatement(ps);
            DB.fechaResultset(rs);
        }


    }

    @Override
    public List<Department> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(
                    "select * from department order by Name");
            rs = ps.executeQuery();

            List<Department> list = new ArrayList<>();

            while (rs.next()) {
                Department dep = new Department();
                dep.setId(rs.getInt("Id"));
                dep.setName(rs.getString("Name"));
                list.add(dep);
            }
            return list;

        } catch (SQLException e) {
            throw new DbExeption(e.getMessage());
        } finally {
            DB.fechaStatement(ps);
            DB.fechaResultset(rs);
        }

    }
}
