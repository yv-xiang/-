package com.offcn.company.dao;

import com.offcn.company.bean.Company;

import java.util.List;

public interface CompanyDao {
    public List<Company> findAll();
    public int addCom(Company company);
    public int updateCom(Company company);
    public Company selectOne(Integer id);
    public int deleteComById(Integer id);


}
