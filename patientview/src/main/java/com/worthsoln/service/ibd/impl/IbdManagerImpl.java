package com.worthsoln.service.ibd.impl;

import com.worthsoln.ibd.model.CarePlan;
import com.worthsoln.ibd.model.MyIbd;
import com.worthsoln.ibd.model.medication.Medication;
import com.worthsoln.ibd.model.medication.MedicationDose;
import com.worthsoln.ibd.model.medication.MedicationType;
import com.worthsoln.ibd.model.medication.MyMedication;
import com.worthsoln.patientview.model.User;
import com.worthsoln.patientview.model.UserMapping;
import com.worthsoln.repository.ibd.CarePlanDao;
import com.worthsoln.repository.ibd.MedicationDao;
import com.worthsoln.repository.ibd.MedicationTypeDao;
import com.worthsoln.repository.ibd.MyIbdDao;
import com.worthsoln.repository.ibd.MyMedicationDao;
import com.worthsoln.repository.ibd.impl.MedicationDoseDao;
import com.worthsoln.service.UserManager;
import com.worthsoln.service.ibd.IbdManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(value = "ibdManager")
public class IbdManagerImpl implements IbdManager {

    @Inject
    private MyIbdDao myIbdDao;

    @Inject
    private CarePlanDao carePlanDao;

    @Inject
    private UserManager userManager;

    @Inject
    private MedicationDao medicationDao;

    @Inject
    private MedicationDoseDao medicationDoseDao;

    @Inject
    private MedicationTypeDao medicationTypeDao;

    @Inject
    MyMedicationDao myMedicationDao;

    @Override
    public MyIbd getMyIbd(User user) {
        String nhsNo = getNhsNumber(user);

        if (nhsNo != null) {
            return getMyIbd(nhsNo);
        }

        return null;
    }

    @Override
    public MyIbd getMyIbd(String nhsno) {
        return myIbdDao.get(nhsno);
    }

    @Override
    public void saveMyIbd(MyIbd myIbd) {
        myIbdDao.save(myIbd);
    }

    @Override
    public CarePlan getCarePlan(User user) {
        String nhsNo = getNhsNumber(user);

        if (nhsNo != null) {
            return getCarePlan(nhsNo);
        }

        return null;
    }

    @Override
    public CarePlan getCarePlan(String nhsno) {
        return carePlanDao.get(nhsno);
    }

    @Override
    public void saveCarePlan(CarePlan carePlan) {
        carePlanDao.save(carePlan);
    }

    @Override
    public Medication getMedication(Long id) {
        return medicationDao.get(id);
    }

    @Override
    public MedicationDose getMedicationDose(Long id) {
        return medicationDoseDao.get(id);
    }

    @Override
    public MyMedication getMyMedication(Long id) {
        return myMedicationDao.get(id);
    }

    @Override
    public void saveMyMedication(MyMedication myMedication) {
        myMedicationDao.save(myMedication);
    }

    @Override
    public void saveMyMedication(MyMedication myMedication, Long medicationTypeId, Long medicationId,
                                 Long medicationDoseId) {
        if (medicationTypeId != null && medicationTypeId > 0) {
            MedicationType medicationType = getMedicationType(medicationTypeId);

            if (medicationType != null && medicationType.hasValidId()) {
                myMedication.setMedicationType(medicationType);
            }
        }

        if (medicationId != null && medicationId > 0) {
                Medication medication = getMedication(medicationId);

                if (medication != null && medication.hasValidId()) {
                    myMedication.setMedication(medication);
                }
        }

        if (medicationDoseId != null && medicationDoseId > 0) {
            MedicationDose medicationDose = getMedicationDose(medicationDoseId);

            if (medicationDose != null && medicationDose.hasValidId()) {
                myMedication.setMedicationDose(medicationDose);
            }
        }

        myMedicationDao.save(myMedication);
    }

    @Override
    public List<MyMedication> getAllMedications(User user) {
        String nhsNo = getNhsNumber(user);

        if (nhsNo != null) {
            return getAllMedications(nhsNo);
        }

        return null;
    }

    @Override
    public List<MyMedication> getAllMedications(String nhsno) {
        return myMedicationDao.getAllMedications(nhsno);
    }

    @Override
    public List<MyMedication> getCurrentMedications(User user) {
        String nhsNo = getNhsNumber(user);

        if (nhsNo != null) {
            return getCurrentMedications(nhsNo);
        }

        return null;
    }

    @Override
    public List<MyMedication> getCurrentMedications(String nhsno) {
        return myMedicationDao.getCurrentMedications(nhsno);
    }

    @Override
    public List<MyMedication> getStoppedMedications(User user) {
        String nhsNo = getNhsNumber(user);

        if (nhsNo != null) {
            return getStoppedMedications(nhsNo);
        }

        return null;
    }

    @Override
    public List<MyMedication> getStoppedMedications(String nhsno) {
        return myMedicationDao.getStoppedMedications(nhsno);
    }

    @Override
    public MedicationType getMedicationType(Long id) {
        return medicationTypeDao.get(id);
    }

    @Override
    public List<MedicationType> getMedicationTypes() {
        return medicationTypeDao.getAll();
    }

    private String getNhsNumber(User user) {
        UserMapping userMapping = userManager.getUserMappingPatientEntered(user);

        if (userMapping != null) {
            return userMapping.getNhsno();
        }

        return null;
    }
}
