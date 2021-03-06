package com.worthsoln.repository;

import com.worthsoln.patientview.logon.UnitAdmin;
import com.worthsoln.patientview.model.Specialty;
import com.worthsoln.patientview.model.Unit;
import com.worthsoln.patientview.model.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Transactional(propagation = Propagation.MANDATORY)
public interface UnitDao {

    Unit get(Long id);

    Unit get(String unitCode, Specialty specialty);

    void save(Unit unit);

    List<Unit> getAll(boolean sortByName);

    List<Unit> getAll(boolean sortByName, Specialty specialty);

    List<Unit> getAll(String[] sourceTypesToExclude, String[] sourceTypesToInclude);

    List<Unit> getUnitsWithUser(Specialty specialty);

    List<Unit> getAdminsUnits(Specialty specialty);

    List<Unit> get(List<String> usersUnitCodes, Specialty specialty);

    List<Unit> get(List<String> usersUnitCodes, String[] notTheseUnitCodes, String[] plusTheseUnitCodes,
                   Specialty specialty);

    List<UnitAdmin> getUnitUsers(String unitcode, Specialty specialty);

    List<User> getUnitPatientUsers(String unitcode, Specialty specialty);
}
