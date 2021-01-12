package com.offcn.company.Service;

import com.offcn.company.bean.Company;

import java.util.List;

public interface CompanyService {
    public List<Company> getFind();
    public boolean addCom(Company company);
    public boolean UpdateCom(Company company);
    public Company find(Integer id);
    public void deletCom(Integer id);
}
