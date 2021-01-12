package com.offon.department.dao.impl;

import com.offon.department.bean.Eept;
import com.offon.department.bean.Employee;
import com.offon.department.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private JdbcTemplate template;

    @Override
    public List<Employee> findallEmp() {

        String sql =" select t_employee.id,t_employee.name,sex,registerDate,dept_id from  t_employee ";
        return  template.query(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSex(resultSet.getString("sex"));
                employee.setRegisterDate(resultSet.getDate("registerDate"));
                return employee;
            }
        });
    }
    @Override
    public int insertEmp(Employee employee) {
        String sql = "inert into t_employee(name,sex,registerDate,dept_id)values(?,?,?,?) ";
        return  template.update(sql,employee.getName(),employee.getSex(),employee.getRegisterDate(),employee.getDept_id());
    }

    @Override
    public int updateEmp(Employee employee) {
        String sql ="update t_employee set name=?,sex=?,registerDate=?,dept_id=? ";
        return template.update(sql,employee.getName(),employee.getSex(),employee.getRegisterDate(),employee.getDept_id(),employee.getDept_id());
    }

    @Override
    public int deleteEmpById(Integer id) {
        String sql = "delete from t_employee where id=? ";
        return  template.update(sql,id);

    }
}
