package com.offcn.company.Service.impl;

import com.offcn.company.Service.CompanyService;
import com.offcn.company.bean.Company;
import com.offcn.company.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;
    @Override
    public List<Company> getFind() {

        return companyDao.findAll();

    }

    @Override
    public boolean addCom(Company company) {
        int addCom = companyDao.addCom(company);
        if(addCom==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean UpdateCom(Company company) {
        int i = companyDao.updateCom(company);
        if (i==1){
            return true;
        }
        return false;
    }

    @Override
    public Company find(Integer id) {
        return  companyDao.selectOne(id);
    }

    @Override
    public void deletCom(Integer id) {
        companyDao.deleteComById(id);
    }
}
