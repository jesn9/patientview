package com.worthsoln.service.impl;

import com.worthsoln.patientview.logon.UnitAdmin;
import com.worthsoln.patientview.model.Tenancy;
import com.worthsoln.patientview.model.TenancyUserRole;
import com.worthsoln.patientview.model.UserMapping;
import com.worthsoln.patientview.model.User;
import com.worthsoln.repository.TenancyUserRoleDao;
import com.worthsoln.repository.UserDao;
import com.worthsoln.repository.UserMappingDao;
import com.worthsoln.service.SecurityUserManager;
import com.worthsoln.service.UserManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 *
 */
@Service(value = "userManager")
public class UserManagerImpl implements UserManager {

    @Inject
    private UserDao userDao;

    @Inject
    private UserMappingDao userMappingDao;

    @Inject
    private SecurityUserManager securityUserManager;

    @Inject
    private TenancyUserRoleDao tenancyUserRoleDao;

    @Override
    public User getLoggedInUser() {
        return userDao.get(securityUserManager.getLoggedInUsername());
    }

    @Override
    public User get(Long id) {
        return userDao.get(id);
    }

    @Override
    public User get(String username) {
        return userDao.get(username);
    }

    @Override
    public String getLoggedInUserRole() {

        // get role from spring user for this logged in tenancy
        return getCurrentTenancyRole(getLoggedInUser());
    }

    @Override
    public Tenancy getCurrentTenancy(User user) {

        TenancyUserRole tenancyUserRole = getCurrentTenancyUserRole(user);

        if (tenancyUserRole != null) {
            return tenancyUserRole.getTenancy();
        } else {
            return null;
        }
    }

    @Override
    public String getCurrentTenancyRole(User user) {

        TenancyUserRole tenancyUserRole = getCurrentTenancyUserRole(user);

        if (tenancyUserRole != null) {
            return tenancyUserRole.getRole();
        } else {
            return null;
        }
    }

    private TenancyUserRole getCurrentTenancyUserRole(User user) {

        // get role from spring user for this logged in tenancy
        if (user != null) {
            List<TenancyUserRole> tenancyUserRoles = getTenancyUserRoles(user);
            Tenancy loggedInTenancy = securityUserManager.getLoggedInTenancy();

            if (loggedInTenancy != null) {
                for (TenancyUserRole tenancyUserRole : tenancyUserRoles) {

                    if (tenancyUserRole.getTenancy().equals(loggedInTenancy)) {
                        return tenancyUserRole;
                    }
                }
            }
        }

        return null;
    }

    @Override
    public List<TenancyUserRole> getTenancyUserRoles(User user) {
        return tenancyUserRoleDao.get(user);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User saveUserFromUnitAdmin(UnitAdmin unitAdmin) {

        // check for an existing user
        User user = get(unitAdmin.getUsername());

        if (user == null) {
            // create a user to save based on the unitAdmin
            user = new User();
        }
        user.setAccountlocked(unitAdmin.isAccountlocked());
        user.setDummypatient(unitAdmin.isDummypatient());
        user.setEmail(unitAdmin.getEmail());
        user.setEmailverified(unitAdmin.isEmailverfied());
        user.setFailedlogons(unitAdmin.getFailedlogons());
        user.setFirstlogon(unitAdmin.isFirstlogon());
        user.setLastlogon(unitAdmin.getLastlogon());
        user.setName(unitAdmin.getName());
        user.setPassword(unitAdmin.getPassword());
        user.setScreenname(unitAdmin.getScreenname());
        user.setUsername(unitAdmin.getUsername());

        save(user);

        // handle the permissions for the tenancy

        TenancyUserRole tenancyUserRole = getCurrentTenancyUserRole(user);

        if (tenancyUserRole == null) {
            // associate new user with the current tenancy and role
            tenancyUserRole = new TenancyUserRole();
        }

        // this is always updating the tenancyUserRole - shouldn't be an issue
        tenancyUserRole.setUser(user);
        tenancyUserRole.setRole(unitAdmin.getRole());
        tenancyUserRole.setTenancy(securityUserManager.getLoggedInTenancy());
        tenancyUserRoleDao.save(tenancyUserRole);

        return user;
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void delete(String username) {

        User user = get(username);

        if (user != null) {
            try {
                delete(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    @Override
    public void save(UserMapping userMapping) {
        userMappingDao.save(userMapping);
    }

    @Override
    public void deleteUserMappings(String username, String unitcode) {
        userMappingDao.deleteUserMappings(username, unitcode);
    }

    @Override
    public List<UserMapping> getUserMappings(String username) {
        return userMappingDao.getAll(username);
    }

    @Override
    public List<UserMapping> getUserMappingsExcludeUnitcode(String username, String unitcode) {
        return userMappingDao.getAllExcludeUnitcode(username, unitcode);
    }

    @Override
    public List<UserMapping> getUserMappings(String username, String unitcode) {
        return userMappingDao.getAll(username, unitcode);
    }

    @Override
    public List<UserMapping> getUserMappingsForNhsNo(String nhsNo) {
        return userMappingDao.getAllForNhsNo(nhsNo);
    }

    @Override
    public String getUsersRealUnitcodeBestGuess(String username) {
        return userMappingDao.getUsersRealUnitcodeBestGuess(username);
    }

    @Override
    public String getUsersRealNhsNoBestGuess(String username) {
        return userMappingDao.getUsersRealNhsNoBestGuess(username);
    }

    @Override
    public UserMapping getUserMappingPatientEntered(User user) {
        return userMappingDao.getUserMappingPatientEntered(user);
    }

    @Override
    public List<UserMapping> getUsersSiblings(String username, String unitcode) {
        return userMappingDao.getUsersSiblings(username, unitcode);
    }

    @Override
    public List<UserMapping> getDuplicateUsers(String nhsno, String username) {
        return userMappingDao.getDuplicateUsers(nhsno, username);
    }

    @Override
    public List getUnitUsers(String unitcode) {
        return userDao.getUnitUsers(unitcode, securityUserManager.getLoggedInTenancy());
    }
}
