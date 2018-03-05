package lab2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * In this lab focus on METHOD encapsulation and fix/add code as necessary.
 * Pay special attention to the following issues:
 *    1. Not all methods need to be public
 *    2. When methods need to be called in a certain order you can do this
 *       by creating a parent method that calls the other, helper methods.
 *    3. There is some duplicate code used that violates the D.R.Y. principle.
 *       Eliminate that by encapsulating the duplicate code in a new method
 *       and then call that method in place of the duplicate code
 *    4. All method parameters should be validated.
 * 
 * Review the tips in the document "EncapCheckList.pdf" if needed.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.02
 */
public class Employee {
    private String firstName;
    private String lastName;
    private String ssn;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private Date orientationDate;


    public Employee(String firstName, String lastName, String ssn) {
        setFirstName(firstName);
        setLastName((lastName));
        setSsn(ssn);
    }
    /* needs a method to force the order in which they are performed
    make method names this long and descriptive
    methods that have boolean start with 'is'
    */
    public void firstDayOrientation(String cubeId) {
        orientationDate = new Date();
        meetWithHrForBenefitAndSalryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
        moveIntoCubicle(cubeId);
    }

    private String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        return sdf.format(orientationDate);
    }

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired.
    private void meetWithHrForBenefitAndSalryInfo() {
        metWithHr = true;
        System.out.println(firstName + " " + lastName + " met with Hr on "
            + getFormattedDate());
    }

    // Assume this must be performed second, and assume that an employee
    // would only do this once, upon being hired.:
    private void meetDepartmentStaff() {
        metDeptStaff = true;
        System.out.println(firstName + " " + lastName + " met with Dept. Staff on "
            + getFormattedDate());
    }

    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called 
    // independently from other classes.
    //since it will be called independently from other classes, you keep it public
    public void reviewDeptPolicies() {
        reviewedDeptPolicies = true;
        System.out.println(firstName + " " + lastName + " reviewed Dept policies on "
            + getFormattedDate());
    }

    // Assume this must be performed 4th. And assume that because employees
    // sometimes change office locations that this method may need to be called 
    // independently from other classes.
    //since it will be called independently from other classes, you keep it public
    public void moveIntoCubicle(String cubeId) {
        this.cubeId = cubeId;
        this.movedIn = true;
        System.out.println(firstName + " " + lastName + " moved into cubicle "
                + cubeId + " on " + getFormattedDate());
    }

    public String getFirstName() {
        return firstName;
    }

    // setter methods give the developer the power to control what data is
    // allowed through validation.
    
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty() || firstName.length() < 3 ){
            throw new IllegalArgumentException("Sorry first name is mandatory and must be at least 3 characters.")
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        if (lastName == null || lastName.isEmpty() || lastName.length() < 3 ){
            throw new IllegalArgumentException("Sorry last name is mandatory and must be at least 3 characters.")
        }
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        if (ssn.matches("\\d{3}-\\d{2}-\\d{4}")){
            this.ssn = ssn;
        }else{
            throw new IllegalArgumentException("sorry first SSN must match legal SSN  format XXX-XX-XXXX")
        }
    }

    public boolean isMetWithHr() {
        return metWithHr;
    }

    // boolean parameters need no validation
    public void setMetWithHr(boolean metWithHr) {
        this.metWithHr = metWithHr;
    }

    public boolean isMetDeptStaff() {
        return metDeptStaff;
    }

    public void setMetDeptStaff(boolean metDeptStaff) {
        this.metDeptStaff = metDeptStaff;
    }

    public boolean isReviewedDeptPolicies() {
        return reviewedDeptPolicies;
    }

    public void setReviewedDeptPolicies(boolean reviewedDeptPolicies) {
        this.reviewedDeptPolicies = reviewedDeptPolicies;
    }

    public boolean isMovedIn() {
        return movedIn;
    }

    public void setMovedIn(boolean movedIn) {
        this.movedIn = movedIn;
    }

    public String getCubeId() {
        return cubeId;
    }

    
    public void setCubeId(String cubeId) {
        if(cubeId == null || cubeId.isEmpty()) {
            System.out.println("cube id is required");
        }
        this.cubeId = cubeId;
    }

    public Date getOrientationDate() {
        return orientationDate;
    }

    public void setOrientationDate(Date orientationDate) {
        if(orientationDate == null) {
            System.out.println("orientationDate is required");
        }
        this.orientationDate = orientationDate;
    }
}
