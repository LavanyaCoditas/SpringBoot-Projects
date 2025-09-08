package com.lavanyaSpringBootProject.AOP_project.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDAOImpl implements MemberShipDAO{
    @Override
    public void addAccountMembership() {
        System.out.println("member method of add");
    }

    @Override
    public int returnNumber() {
        return 1010;
    }
}
