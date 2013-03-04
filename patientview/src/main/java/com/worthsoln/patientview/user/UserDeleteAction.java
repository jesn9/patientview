package com.worthsoln.patientview.user;

import com.worthsoln.patientview.model.User;
import com.worthsoln.patientview.logging.AddLog;
import com.worthsoln.patientview.logon.PatientLogon;
import com.worthsoln.patientview.model.UserMapping;
import com.worthsoln.patientview.model.Unit;
import com.worthsoln.patientview.unit.UnitUtils;
import com.worthsoln.utils.LegacySpringUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserDeleteAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {
        String username = BeanUtils.getProperty(form, "username");
        String unitcode = BeanUtils.getProperty(form, "unitcode");
        String nhsno = BeanUtils.getProperty(form, "nhsno");

        List<UserMapping> userMappings
                = LegacySpringUtils.getUserManager().getUserMappingsExcludeUnitcode(username,
                UnitUtils.PATIENT_ENTERS_UNITCODE);

        PatientLogon patient = new PatientLogon();
        Unit unit = UnitUtils.retrieveUnit(unitcode);
        if (userMappings.size() != 0) {
            patient.setUsername(username);
            patient.setNhsno(nhsno);
            User user = LegacySpringUtils.getUserManager().get(username);
            patient.setName(user.getName());
        }

        if (userMappings.size() <= 1) {
            deleteUserMapping(username, unitcode); // deletes from usermapping table
            deleteUserMapping(username + "-GP", unitcode);
            deleteUserMapping(username, UnitUtils.PATIENT_ENTERS_UNITCODE);
            deleteUser(username); // deletes from user table
            deleteUser(username + "-GP");
        } else {
            deleteUserMapping(username, unitcode);
            deleteUserMapping(username + "-GP", unitcode);
        }

        // TODO check whether remove patient should only remove user or remove data too
        if ("patient".equals(patient.getRole()) && !userExistsInRadar(patient.getNhsno())) {
           UserUtils.removePatientFromSystem(patient.getUsername(), patient.getUnitcode());
        }

        AddLog.addLog(LegacySpringUtils.getSecurityUserManager().getLoggedInUsername(), AddLog.PATIENT_DELETE, username,
                nhsno, unitcode, "");
        String mappingToFind = "success";

        request.setAttribute("units", LegacySpringUtils.getUnitManager().getAll(false));
        request.setAttribute("patient", patient);
        request.setAttribute("unit", unit);

        return mapping.findForward(mappingToFind);
    }

    private boolean userExistsInRadar(String nhsno) {
        return LegacySpringUtils.getUserManager().existsInRadar(nhsno);
    }

    private void deleteUserMapping(String username, String unitcode) {
        LegacySpringUtils.getUserManager().deleteUserMappings(username, unitcode);
    }

    private void deleteUser(String username) {
        LegacySpringUtils.getUserManager().delete(username);
    }

}
