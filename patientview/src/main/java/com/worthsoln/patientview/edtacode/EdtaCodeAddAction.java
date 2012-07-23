package com.worthsoln.patientview.edtacode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.worthsoln.patientview.model.EdtaCode;
import com.worthsoln.utils.LegacySpringUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.worthsoln.patientview.logon.LogonUtils;
import com.worthsoln.database.action.DatabaseAction;

public class EdtaCodeAddAction extends DatabaseAction {

    public ActionForward execute(
        ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {


        //todo test this, changed from HibernateUtils.extractDataFromFormMakeObjectAndAdd

        EdtaCode edtaCode = EdtaCodeUtils.build(form);

        LegacySpringUtils.getEdtaCodeManager().save(edtaCode);

        request.setAttribute("edtaCode", edtaCode);

        return LogonUtils.logonChecks(mapping, request);
    }

    public String getDatabaseName() {
        return "patientview";
    }

    public String getIdentifier() {
        return "edtaCode";
    }
}
