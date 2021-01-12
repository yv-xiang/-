package com.offcn.company.dao.impl;

import com.offcn.company.bean.Company;
import com.offcn.company.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CompanyDaoimpl implements CompanyDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Company> findAll() {
        String sql = "select t_employee.id tid,t_employee.name tname, sex tsex, registerDate tregisterDate," +
                "dept.name,location from t_employee inner join dept where t_employee.dept_id=dept.id";
        return jdbcTemplate.query(sql, new RowMapper<Company>() {
            @Override
            public Company mapRow(ResultSet resultSet, int i) throws SQLException {
                Company company = new Company();
                company.setLocation(resultSet.getString("location"));
                company.setTid(resultSet.getInt("tid"));
                company.setTname(resultSet.getString("tname"));
                company.setTsex(resultSet.getString("tsex"));
                company.setName(resultSet.getString("name"));
                company.setTregisterDate(resultSet.getDate("tregisterDate"));

                return company;
            }
        });

    }

    @Override
    public int addCom(Company company) {
        String sql = "insert into t_employee values(null,?,?,?,?)";
        return jdbcTemplate.update(sql, company.getTname(), company.getTsex(), company.getTregisterDate(), company.getTdeptId());
    }

    @Override
    public int updateCom(Company company) {
        String sql = "update t_employee set name =? , sex = ? , registerDate = ? , dept_id = ? where id = ?";
        return   jdbcTemplate.update(sql, company.getTname(), company.getTsex(), company.getTregisterDate(), company.getTdeptId(), company.getTid());
    }

    @Override
    public Company selectOne(Integer id) {
        String sql = "select t_employee.id tid,t_employee.name tname, t_employee.sex tsex, t_employee.registerDate tregisterDate,dept.name,dept.location from t_employee inner join dept on t_employee.id =? where t_employee.dept_id = dept.id ";
        return  jdbcTemplate.queryForObject(sql, new RowMapper<Company>() {
           @Override
           public Company mapRow(ResultSet resultSet, int i) throws SQLException {
               Company company = new Company();
               company.setLocation(resultSet.getString("location"));
               company.setTid(resultSet.getInt("tid"));
               company.setTname(resultSet.getString("tname"));
               company.setTsex(resultSet.getString("tsex"));
               company.setName(resultSet.getString("name"));
               company.setTregisterDate(resultSet.getDate("tregisterDate"));
               return company;
           }
       },id);

    }

    @Override
    public int deleteComById(Integer id) {
        String sql = "delete from t_employee where id = ?";
        jdbcTemplate.update(sql,id);
        return 0;
    }
}


