package com.worthsoln.test.helpers.impl;

import com.worthsoln.patientview.model.Tenancy;
import com.worthsoln.patientview.model.TenancyUserRole;
import com.worthsoln.patientview.model.User;
import com.worthsoln.repository.TenancyDao;
import com.worthsoln.repository.TenancyUserRoleDao;
import com.worthsoln.repository.UserDao;
import com.worthsoln.test.helpers.RepositoryHelpers;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

/**
 *
 */
@Repository(value = "repositoryHelpers")
public class RepositoryHelpersImpl implements RepositoryHelpers {

    @Inject
    private TenancyDao tenancyDao;

    @Inject
    private UserDao userDao;

    @Inject
    private TenancyUserRoleDao tenancyUserRoleDao;

    @Override
    public User createUser(String username, String email, String password, String name, String screenName) {

        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setUsername(username);
        user.setScreenname(screenName);
        userDao.save(user);

        return user;
    }

    @Override
    public Tenancy createTenancy(String name, String context, String description) {

        Tenancy tenancy = new Tenancy();
        tenancy.setName(name);
        tenancy.setContext(context);
        tenancy.setDescription(description);

        tenancyDao.save(tenancy);

        return tenancy;
    }

    @Override
    public TenancyUserRole createTenancyUserRole(Tenancy tenancy, User user, String role) {

        TenancyUserRole tenancyUserRole1 = new TenancyUserRole();
        tenancyUserRole1.setRole(role);
        tenancyUserRole1.setTenancy(tenancy);
        tenancyUserRole1.setUser(user);
        tenancyUserRoleDao.save(tenancyUserRole1);

        return tenancyUserRole1;
    }
}