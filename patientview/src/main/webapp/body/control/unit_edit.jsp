<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:xhtml/>
<div class="span9">
<div class="page-header">
    <h1>Unit Editing</h1>
</div>

<html:errors />

<html:form action="/control/unitUpdate">

  <table cellpadding="3" >

    <tr>
      <td><img src="images/space.gif" height="10" /> </td>
    </tr>
    <tr>
      <td><b>Code</b></td>
      <td><html:hidden name="unit" property="unitcode" write="true" /></td>
    </tr>

    <tr>
      <td><b>Name</b></td>
      <td><html:text name="unit" property="name" /></td>
    </tr>

    <tr>
      <td><b>Short Name</b></td>
      <td><html:text name="unit" property="shortname" maxlength="15"/></td>
    </tr>

    <logic:present role="superadmin">
    <tr>
      <td><b>Unit sFTP User</b></td>
      <td><html:text name="unit" property="unituser" maxlength="20"/></td>
    </tr>
    </logic:present>

    <logic:notPresent role="superadmin">
        <html:hidden name="unit" property="unituser"/>
    </logic:notPresent>

    <tr>
      <td><b>Address 1</b></td>
      <td><html:text name="unit" property="address1" /></td>
    </tr>

    <tr>
      <td><b>Address 2</b></td>
      <td><html:text name="unit" property="address2" /></td>
    </tr>

    <tr>
      <td><b>Address 3</b></td>
      <td><html:text name="unit" property="address3" /></td>
    </tr>

    <tr>
      <td><b>Postcode</b></td>
      <td><html:text name="unit" property="postcode" /></td>
    </tr>

    <tr>
      <td><b>Unit Web Address</b></td>
      <td><html:text name="unit" property="uniturl" /></td>
    </tr>

    <tr>
      <td><b>Trust Web Address</b></td>
      <td><html:text name="unit" property="trusturl" /></td>
    </tr>

    <tr>
      <td><b>PatientView Admin Name</b></td>
      <td><html:text name="unit" property="renaladminname" /></td>
    </tr>

    <tr>
      <td><b>PatientView Admin Phone</b></td>
      <td><html:text name="unit" property="renaladminphone" /></td>
    </tr>

    <tr>
      <td><b>PatientView Admin Email</b></td>
      <td><html:text name="unit" property="renaladminemail" /></td>
    </tr>

    <tr>
      <td><b>Unit Enquiries Phone</b></td>
      <td><html:text name="unit" property="unitenquiriesphone" /></td>
    </tr>

    <tr>
        <td><b>Unit Enquiries Email</b><br/>(This is where messages to the unit<br/>from patients will be sent)</td>
      <td><html:text name="unit" property="unitenquiriesemail" /></td>
    </tr>

    <tr>
      <td><b>Appointment Phone</b></td>
      <td><html:text name="unit" property="appointmentphone" /></td>
    </tr>

    <tr>
      <td><b>Appointment Email</b></td>
      <td><html:text name="unit" property="appointmentemail" /></td>
    </tr>

    <tr>
      <td><b>Out of Hours Info</b></td>
      <td><html:text name="unit" property="outofhours" /></td>
    </tr>

    <tr>
      <td><b>Peritoneal Dialysis Phone</b></td>
      <td><html:text name="unit" property="peritonealdialysisphone" /></td>
    </tr>

    <tr>
      <td><b>Peritoneal Dialysis Email</b></td>
      <td><html:text name="unit" property="peritonealdialysisemail" /></td>
    </tr>



    <tr><td>&nbsp;</td></tr>
    <tr>
      <td><b>Haemodialysis Unit 1 Name</b></td>
      <td><html:text name="unit" property="haemodialysisunitname1" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 1 Phone</b></td>
      <td><html:text name="unit" property="haemodialysisunitphone1" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 1 Location</b></td>
      <td><html:text name="unit" property="haemodialysisunitlocation1" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 1 Web Address</b></td>
      <td><html:text name="unit" property="haemodialysisuniturl1" /></td>
    </tr>


    <tr><td>&nbsp;</td></tr>
    <tr>
      <td><b>Haemodialysis Unit 2 Name</b></td>
      <td><html:text name="unit" property="haemodialysisunitname2" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 2 Phone</b></td>
      <td><html:text name="unit" property="haemodialysisunitphone2" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 2 Location</b></td>
      <td><html:text name="unit" property="haemodialysisunitlocation2" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 2 Web Address</b></td>
      <td><html:text name="unit" property="haemodialysisuniturl2" /></td>
    </tr>


    <tr><td>&nbsp;</td></tr>
    <tr>
      <td><b>Haemodialysis Unit 3 Name</b></td>
      <td><html:text name="unit" property="haemodialysisunitname3" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 3 Phone</b></td>
      <td><html:text name="unit" property="haemodialysisunitphone3" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 3 Location</b></td>
      <td><html:text name="unit" property="haemodialysisunitlocation3" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 3 Web Address</b></td>
      <td><html:text name="unit" property="haemodialysisuniturl3" /></td>
    </tr>


    <tr><td>&nbsp;</td></tr>

    <tr>
      <td><b>Haemodialysis Unit 4 Name</b></td>
      <td><html:text name="unit" property="haemodialysisunitname4" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 4 Phone</b></td>
      <td><html:text name="unit" property="haemodialysisunitphone4" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 4 Location</b></td>
      <td><html:text name="unit" property="haemodialysisunitlocation4" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 4 Web Address</b></td>
      <td><html:text name="unit" property="haemodialysisuniturl4" /></td>
    </tr>


    <tr><td>&nbsp;</td></tr>

    <tr>
      <td><b>Haemodialysis Unit 5 Name</b></td>
      <td><html:text name="unit" property="haemodialysisunitname5" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 5 Phone</b></td>
      <td><html:text name="unit" property="haemodialysisunitphone5" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 5 Location</b></td>
      <td><html:text name="unit" property="haemodialysisunitlocation5" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 5 Web Address</b></td>
      <td><html:text name="unit" property="haemodialysisuniturl5" /></td>
    </tr>

    <tr><td>&nbsp;</td></tr>

    <tr>
      <td><b>Haemodialysis Unit 6 Name</b></td>
      <td><html:text name="unit" property="haemodialysisunitname6" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 6 Phone</b></td>
      <td><html:text name="unit" property="haemodialysisunitphone6" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 6 Location</b></td>
      <td><html:text name="unit" property="haemodialysisunitlocation6" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 6 Web Address</b></td>
      <td><html:text name="unit" property="haemodialysisuniturl6" /></td>
    </tr>

    <tr><td>&nbsp;</td></tr>

    <tr>
      <td><b>Haemodialysis Unit 7 Name</b></td>
      <td><html:text name="unit" property="haemodialysisunitname7" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 7 Phone</b></td>
      <td><html:text name="unit" property="haemodialysisunitphone7" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 7 Location</b></td>
      <td><html:text name="unit" property="haemodialysisunitlocation7" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 7 Web Address</b></td>
      <td><html:text name="unit" property="haemodialysisuniturl7" /></td>
    </tr>

    <tr><td>&nbsp;</td></tr>

    <tr>
      <td><b>Haemodialysis Unit 8 Name</b></td>
      <td><html:text name="unit" property="haemodialysisunitname8" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 8 Phone</b></td>
      <td><html:text name="unit" property="haemodialysisunitphone8" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 8 Location</b></td>
      <td><html:text name="unit" property="haemodialysisunitlocation8" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 8 Web Address</b></td>
      <td><html:text name="unit" property="haemodialysisuniturl8" /></td>
    </tr>

    <tr><td>&nbsp;</td></tr>

    <tr>
      <td><b>Haemodialysis Unit 9 Name</b></td>
      <td><html:text name="unit" property="haemodialysisunitname9" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 9 Phone</b></td>
      <td><html:text name="unit" property="haemodialysisunitphone9" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 9 Location</b></td>
      <td><html:text name="unit" property="haemodialysisunitlocation9" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 9 Web Address</b></td>
      <td><html:text name="unit" property="haemodialysisuniturl9" /></td>
    </tr>

    <tr><td>&nbsp;</td></tr>

    <tr>
      <td><b>Haemodialysis Unit 10 Name</b></td>
      <td><html:text name="unit" property="haemodialysisunitname10" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 10 Phone</b></td>
      <td><html:text name="unit" property="haemodialysisunitphone10" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 10 Location</b></td>
      <td><html:text name="unit" property="haemodialysisunitlocation10" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 10 Web Address</b></td>
      <td><html:text name="unit" property="haemodialysisuniturl10" /></td>
    </tr>

    <tr><td>&nbsp;</td></tr>

    <tr>
      <td><b>Haemodialysis Unit 11 Name</b></td>
      <td><html:text name="unit" property="haemodialysisunitname11" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 11 Phone</b></td>
      <td><html:text name="unit" property="haemodialysisunitphone11" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 11 Location</b></td>
      <td><html:text name="unit" property="haemodialysisunitlocation11" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 11 Web Address</b></td>
      <td><html:text name="unit" property="haemodialysisuniturl11" /></td>
    </tr>

    <tr><td>&nbsp;</td></tr>

    <tr>
      <td><b>Haemodialysis Unit 12 Name</b></td>
      <td><html:text name="unit" property="haemodialysisunitname12" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 12 Phone</b></td>
      <td><html:text name="unit" property="haemodialysisunitphone12" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 12 Location</b></td>
      <td><html:text name="unit" property="haemodialysisunitlocation12" /></td>
    </tr>

    <tr>
      <td><b>Haemodialysis Unit 12 Web Address</b></td>
      <td><html:text name="unit" property="haemodialysisuniturl12" /></td>
    </tr>


    <tr>
      <td><html:submit value="Update" styleClass="btn"/></td>
    </tr>

  </table>

</html:form>
</div>
</div>

